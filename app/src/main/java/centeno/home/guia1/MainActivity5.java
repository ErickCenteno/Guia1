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

public class MainActivity5 extends AppCompatActivity {

    EditText palabra;
    Button btnPalindromo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        // Ajustes para la interfaz
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a los elementos de la vista
        palabra = findViewById(R.id.Palabra);
        btnPalindromo = findViewById(R.id.BtnPalindromo);

        // Configurar el botón para verificar si la palabra es un palíndromo
        btnPalindromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoPalabra = palabra.getText().toString().trim();

                // Validar que el campo no esté vacío
                if (!textoPalabra.isEmpty()) {
                    boolean esPalindromo = esPalindromo(textoPalabra);

                    // Mostrar el resultado
                    String mensaje = esPalindromo ? "La palabra \"" + textoPalabra + "\" es un palíndromo." : "La palabra \"" + textoPalabra + "\" no es un palíndromo.";
                    Toast.makeText(MainActivity5.this, mensaje, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity5.this, "Por favor, ingresa una palabra.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para verificar si una palabra es un palíndromo
    private boolean esPalindromo(String palabra) {
        String palabraInvertida = new StringBuilder(palabra).reverse().toString();
        return palabra.equalsIgnoreCase(palabraInvertida);
    }
}
