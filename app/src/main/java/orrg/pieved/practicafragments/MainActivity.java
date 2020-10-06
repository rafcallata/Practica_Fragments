package orrg.pieved.practicafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton OpcionPeli1, OpcionPeli2;

    int Votos1=0, Votos2=0;
    FragmentTransaction transaction;
    Fragment fragmentPrincipal,fragmentOpcion1,fragmentOpcion2;
    String ganador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OpcionPeli1 =  findViewById(R.id.btn_Opcion1);
        OpcionPeli2 =  findViewById(R.id.btn_Opcion2);

        fragmentPrincipal = new Principal();
        fragmentOpcion1 =new Opcion1();
        fragmentOpcion2 =new Opcion2();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmentPrincipal).commit();

        OpcionPeli1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Votos1 = Votos1 + 1;
                Toast.makeText(getApplicationContext(),Votos1+"Total Votos para ", Toast.LENGTH_SHORT).show();
            }
        });
        OpcionPeli2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Votos2 = Votos2 + 1;
                Toast.makeText(getApplicationContext(),Votos2+"Total Votos para "  , Toast.LENGTH_SHORT).show();
            }
        });



        Button resultado = (Button)findViewById(R.id.btn_contarvotos);
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction=getSupportFragmentManager().beginTransaction();


                int A = Votos1;
                int B = Votos2;

                if (A>B){
                    transaction.replace(R.id.contenedor,fragmentOpcion1);
                    transaction.addToBackStack(null);
                }
                else if(B>A){
                    transaction.replace(R.id.contenedor,fragmentOpcion2 );
                    transaction.addToBackStack(null);
                }
                else {
                    Toast.makeText(getApplicationContext()," EMPATE "  , Toast.LENGTH_SHORT).show();
                }
                transaction.commit();

            }
        });
    }
}