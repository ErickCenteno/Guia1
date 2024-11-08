package centeno.home.guia1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnMultiplicacionRusa, btnNumeroPrimo, btnPalindromo, btnAcercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnMultiplicacionRusa = findViewById(R.id.BtnMultiplicacionRusa);
        btnNumeroPrimo = findViewById(R.id.BtnNumeroPrimo);
        btnPalindromo = findViewById(R.id.BtnPalindromo);
        btnAcercaDe = findViewById(R.id.BtnAcercaDe);

        // Configurar los botones para que abran las actividades correspondientes
        btnMultiplicacionRusa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btnNumeroPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        btnPalindromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }
        });

        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
                startActivity(intent);
            }
        });
    }
}