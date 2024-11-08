package centeno.home.guia1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    EditText numeroA;
    Button btnVerificarPrimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        // Ajustes para la interfaz
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a los elementos de la vista
        numeroA = findViewById(R.id.NumeroA);
        btnVerificarPrimo = findViewById(R.id.BtnVerificarPrimo);

        // Configurar el botón para verificar si el número es primo
        btnVerificarPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorA = numeroA.getText().toString();

                // Validar que el campo no esté vacío
                if (!valorA.isEmpty()) {
                    int numero = Integer.parseInt(valorA);
                    boolean esPrimo = esNumeroPrimo(numero);

                    // Mostrar el resultado
                    String mensaje = esPrimo ? "El número " + numero + " es primo." : "El número " + numero + " no es primo.";
                    Toast.makeText(MainActivity4.this, mensaje, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity4.this, "Por favor, ingresa un número.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para verificar si un número es primo
    private boolean esNumeroPrimo(int num) {
        if (num <= 1) return false; // Números menores o iguales a 1 no son primos
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Si es divisible por cualquier número, no es primo
            }
        }
        return true; // Si no es divisible por ninguno, es primo
    }
}
