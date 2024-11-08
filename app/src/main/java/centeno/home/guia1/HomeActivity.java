package centeno.home.guia1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Obtener el nombre del usuario desde el Intent
        String username = getIntent().getStringExtra("Nombre"); // Cambiado a "Nombre"

        // Configurar el TextView con el nombre del usuario
        TextView userNameTextView = findViewById(R.id.userNameText);
        if (username != null && !username.isEmpty()) {
            userNameTextView.setText(username); // Establecer el nombre del usuario
        }

        // Configurar el botón "Aplicaciones"
        Button appsButton = findViewById(R.id.appsButton);
        appsButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}
