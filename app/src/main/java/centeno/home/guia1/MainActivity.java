package centeno.home.guia1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameEdiText, passwordEdiText;
    Button loginButton;

    TextView timerTextView;

    CountDownTimer countDownTimer;

    int loginAttemps = 0;

    CheckBox showPasswordCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEdiText = findViewById(R.id.usernameEdiText);
        passwordEdiText = findViewById(R.id.passwordEdiText);
        loginButton = findViewById(R.id.loginButton);
        timerTextView = findViewById(R.id.timerTextView);
        showPasswordCheckBox = findViewById(R.id.showPasswordCheckBox);

        // Lógica para mostrar/ocultar la contraseña
        showPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // Mostrar la contraseña
                    passwordEdiText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    // Ocultar la contraseña
                    passwordEdiText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                // Mover el cursor al final del texto
                passwordEdiText.setSelection(passwordEdiText.length());
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlelogin();
            }
        });
    }

    //FUNCION PARA MANEJAR EL LOGIN
    private void handlelogin() {
        String username = usernameEdiText.getText().toString();
        String password = passwordEdiText.getText().toString();

        //Validación de usuario y contraseña
        if ("Ce123".equals(password)) {
            Toast.makeText(this, "Inicio de sesión correcto!", Toast.LENGTH_SHORT).show();
            loginAttemps = 0; //Reiniciar intentos

            //Inciamos la nueva activity
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("Nombre", username);
            startActivity(intent);
            finish();

        } else {
            loginAttemps++;
            if (loginAttemps >= 3) {
                loginButton.setEnabled(false);
                startCountDown();
            } else {
                passwordEdiText.setError("Usuario o contraseña incorrectas. Intentos " + loginAttemps + " de 3");
            }
        }
    }

    private void startCountDown() {
        timerTextView.setVisibility(View.VISIBLE);
        if (countDownTimer != null){
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l / 1000) + "s restantes");
            }

            @Override
            public void onFinish() {
                timerTextView.setVisibility(View.GONE);
                loginButton.setEnabled(true);
                loginAttemps = 0;
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Cancelar contador
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}
