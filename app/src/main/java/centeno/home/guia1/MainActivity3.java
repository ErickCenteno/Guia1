package centeno.home.guia1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText numeroA, numeroB;
    Button proceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Referencias a los elementos de la vista
        numeroA = findViewById(R.id.NumeroA);
        numeroB = findViewById(R.id.NumeroB);
        proceso = findViewById(R.id.Proceso);

        // Configurar el botón "Proceso"
        proceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados
                String valorA = numeroA.getText().toString();
                String valorB = numeroB.getText().toString();

                // Validar que los campos no estén vacíos
                if (!valorA.isEmpty() && !valorB.isEmpty()) {
                    // Convertir a números
                    int multiplicando = Integer.parseInt(valorA);
                    int multiplicador = Integer.parseInt(valorB);

                    // Calcular la multiplicación rusa
                    int resultado = multiplicacionRusa(multiplicando, multiplicador);

                    // Mostrar el resultado
                    Toast.makeText(MainActivity3.this, "Resultado: " + resultado, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity3.this, "Por favor, ingresa ambos números.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para calcular la multiplicación rusa
    private int multiplicacionRusa(int a, int b) {
        int resultado = 0;

        while (a > 0) {
            // Si el número multiplicando es impar, se suma el multiplicador al resultado
            if (a % 2 != 0) {
                resultado += b;
            }
            // Duplicar el multiplicador y dividir el multiplicando entre 2
            a /= 2;
            b *= 2;
        }
        return resultado;
    }
}
