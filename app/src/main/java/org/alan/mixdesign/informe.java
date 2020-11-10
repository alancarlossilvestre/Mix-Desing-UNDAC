package org.alan.mixdesign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class informe extends AppCompatActivity {
    Spinner select_marca, uso_aditivo, ensayos_previos, tipo_de_diseño,
            tipo_de_exposicion, asentamiento, especifique_tipo_estructura, consolidacion_vibracion,
            tam_max_agregado, especifique_tipo_expo_concreto, spinner_fuente_agua;

    TextView peso_especifico_cemento, asentamiento_preferencia;

    TextInputEditText resistencia_del_diseño, desviacion_estandar, numero_de_ensayos, modulo_ag_grueso, peso_sc_agre_gru,humedad_a_f,
            peso_e_a_f, absorcion_ag_grueso, humendad_ag_grueso, absorcion_ag_fino, aditivo, densidad_aditivo, mezcla_necesaria, peso_e_a_g;
    double d_rel_agua_ceme_durabilidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);
        select_marca = (Spinner)findViewById(R.id.spinner_select_marca);
        uso_aditivo = (Spinner)findViewById(R.id.spinner_uso_aditivo);
        tipo_de_diseño = (Spinner)findViewById(R.id.spinner_tipo_de_diseño);
        asentamiento =(Spinner)findViewById(R.id.spinner_asentamiento);
        especifique_tipo_estructura = (Spinner)findViewById(R.id.spinner_tipo_de_estructura);
        consolidacion_vibracion = (Spinner)findViewById(R.id.spinner_consolidacion_por_vibracion);
        tam_max_agregado = (Spinner)findViewById(R.id.spinner_tamaño_max_del_agregado);
        tipo_de_exposicion = (Spinner)findViewById(R.id.spinner_tipo_de_exposicion);
        especifique_tipo_expo_concreto =(Spinner)findViewById(R.id.spinner_tipo_de_exposicion_especifique);
        spinner_fuente_agua = (Spinner)findViewById(R.id.spinner_agua) ;

        peso_especifico_cemento = (TextView)findViewById(R.id.viewpeso_especifico);
        asentamiento_preferencia = (TextView)findViewById(R.id.viewasentamiento_de_preferencia);

        resistencia_del_diseño =(TextInputEditText)findViewById(R.id.inputresistencia_del_diseño);
        desviacion_estandar =(TextInputEditText)findViewById(R.id.inpudesviacion_estandar);
        numero_de_ensayos = (TextInputEditText)findViewById(R.id.inputnumerode_ensayos);
        modulo_ag_grueso = (TextInputEditText)findViewById(R.id.inputmodulo_finura_a_f);
        peso_sc_agre_gru= (TextInputEditText)findViewById(R.id.inputpe_unitario_compactado_agregado_grueso);
        peso_e_a_f = (TextInputEditText)findViewById(R.id.inputpeso_especifico_a_f);
        humedad_a_f = (TextInputEditText)findViewById(R.id.inputhumedad_natural_a_F);
        absorcion_ag_grueso =  (TextInputEditText)findViewById(R.id.inputpabsorcion_agregado_grueso);
        humendad_ag_grueso = (TextInputEditText)findViewById(R.id.inputhumedad_natural_agregado_grueso);
        absorcion_ag_fino =(TextInputEditText)findViewById(R.id.inputabsorcion_ag_fino);

        aditivo = (TextInputEditText) findViewById(R.id.inputdosis_aditivo);

        densidad_aditivo = (TextInputEditText)findViewById(R.id.inputdensidad_aditivo);

        mezcla_necesaria = (TextInputEditText)findViewById(R.id.inputmezcla_necesaria);
        peso_e_a_g = (TextInputEditText)findViewById(R.id.inputpeso_especifico_agregado_grueso);
        String [] opciones_marca = {"Andino","Sol","Lima","Pacasmayo","Yura", "Selva", "Quisqueya", "Sur"};
        ArrayAdapter<String> adaptder1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  opciones_marca);
        select_marca.setAdapter(adaptder1);
        select_marca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion_opciones_marca = select_marca.getSelectedItem().toString();

                if (seleccion_opciones_marca.equals("Andino") || seleccion_opciones_marca.equals("Selva") || seleccion_opciones_marca.equals("Quisqueya") ){
                    int valor = 3150;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal); }
                else if (seleccion_opciones_marca.equals("Sol") || seleccion_opciones_marca.equals("Lima")){
                    int valor = 3110;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
                else if (seleccion_opciones_marca.equals("Pacasmayo")){
                    int valor = 3120;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
                else if (seleccion_opciones_marca.equals("Yura")){
                    int valor = 3090;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
                else if (seleccion_opciones_marca.equals("Sur")){
                    int valor = 3100;
                    String valorfinal = String.valueOf(valor);
                    peso_especifico_cemento.setText(valorfinal);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String [] select_aditivo = {"Si","No"};
        final ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_aditivo);
        uso_aditivo.setAdapter(adapter);
        uso_aditivo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion_aditivo = uso_aditivo.getSelectedItem().toString();
                if (seleccion_aditivo.equals("No")){
                    alerta_aditivo();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String [] select_t_diseño= {"Con aire", "Sin aire"};
        ArrayAdapter <String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_t_diseño);
        tipo_de_diseño.setAdapter(adapter3);

        String [] select_fuente = {"Potable", "No Potable"};
        ArrayAdapter <String> adapter101= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_fuente);
        spinner_fuente_agua.setAdapter(adapter101);

        final String [] select_asentamiento = {"Seco", "Plastico", "Fluido", "No se tiene" };
        ArrayAdapter <String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_asentamiento);
        asentamiento.setAdapter(adapter5);

        final String [] select_tipo_estructura = {"Zapatas y muros de cimentacion armados", "Cimentaciones simples, Cajones, subestructuras de muros",
                "Vigas y muros armados", "Columnas de edificios", "Losas y pavimentos", "Concreto ciclopeo", "No es necesario"};
        ArrayAdapter <String> adapter6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_tipo_estructura);
        especifique_tipo_estructura.setAdapter(adapter6);
        especifique_tipo_estructura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion_opciones_marca = especifique_tipo_estructura.getSelectedItem().toString();

                if (seleccion_opciones_marca.equals("Zapatas y muros de cimentacion armados") ||
                        seleccion_opciones_marca.equals( "Cimentaciones simples, Cajones, subestructuras de muros")
                        || seleccion_opciones_marca.equals("Losas y pavimentos") ){
                    int valor1 = 1;
                    int valor2 =  3;
                    String valorfinal1 = String.valueOf(valor1);
                    String valorfinal2 = String.valueOf(valor2);
                    asentamiento_preferencia.setText(" De "+valorfinal1 + " '' a   " +valorfinal2 + " ''"); }
                else if (seleccion_opciones_marca.equals("Vigas y muros armados") ||
                        seleccion_opciones_marca.equals( "Columnas de edificios") ){
                    int valor1 = 1;
                    int valor2 =  4;
                    String valorfinal1 = String.valueOf(valor1);
                    String valorfinal2 = String.valueOf(valor2);
                    asentamiento_preferencia.setText(" De "+valorfinal1 + " '' a   " +valorfinal2 + " ''"); }
                else if (seleccion_opciones_marca.equals("Concreto ciclopeo")){
                    int valor1 = 1;
                    int valor2 =  2;
                    String valorfinal1 = String.valueOf(valor1);
                    String valorfinal2 = String.valueOf(valor2);
                    asentamiento_preferencia.setText(" De "+valorfinal1 + " '' a   " +valorfinal2 + " ''"); }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        String [] select_consolidacion_vibracion = {"Si", "No"};
        ArrayAdapter <String> adapter8 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_consolidacion_vibracion);
        consolidacion_vibracion.setAdapter(adapter8);

        String [] select_tamano_max_agregado = {"3/8''"," 1/2''", "3/4''","1''","1 1/2''","2''","3''","6''"};
        ArrayAdapter <String> adapter9 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,  select_tamano_max_agregado);
        tam_max_agregado.setAdapter(adapter9);

        String [] select_tipo_de_exposicion = {"Baja permeabilidad", "Exposición al ataque de sulfatos", "Proceso de congelamiento de deshielo"
                , "Proceso contra la corrosión del concreto","Ninguno"};
        ArrayAdapter <String> adapter10 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, select_tipo_de_exposicion);
        tipo_de_exposicion.setAdapter(adapter10);

        tipo_de_exposicion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = tipo_de_exposicion.getSelectedItem().toString();
                if (seleccion.equals("Baja permeabilidad")) {

                    especifique_baja_permeabilidad();
                }
                if (seleccion.equals("Exposición al ataque de sulfatos")) {
                    especifique_exposición_al_ataque_de_sulfatos();
                }
                if (seleccion.equals("Proceso de congelamiento de deshielo")) {
                    especifique_proceso_de_congelamiento_de_deshielo();
                }
                if (seleccion.equals("Proceso contra la corrosión del concreto")) {
                    especifique_proceso_contra_la_corrosión_del_concreto();
                }
                if (seleccion.equals("Ninguno")) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void especifique_baja_permeabilidad(){
        String[] opciones_2 = {"Expuesto a agua dulces", "Expuesto a agua dulce o solubles", "Expuesto a aguas cloacales"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
    }
    public void especifique_exposición_al_ataque_de_sulfatos(){
        String[] opciones_2 = {"Despreciable", "Moderada", "Severa", "Muy servera"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
    }
    public void especifique_proceso_de_congelamiento_de_deshielo(){
        String[] opciones_2 = {"Suave", "Moderada", "Severa"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
    }

    public void especifique_proceso_contra_la_corrosión_del_concreto(){
        String[] opciones_2 = {"Recubrimiento mínimo incrementado a 15mm", "Recubrimiento mínimo no incrementado a 15mm", "Severa"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones_2);
        especifique_tipo_expo_concreto.setAdapter(adaptader);
    }

    public void alerta_tipo_expo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Alerta");
        builder.setMessage("resistencia del diseño muy bajo para el tipo de exposicion")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }

    public void alerta_aditivo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomDialogTheme);
        builder.setTitle("Aviso");
        builder.setMessage("Ya que el diseño de mezcla no lleva aditivo, por favor relleno campos" +
                "de dosis y densidad con el valor de cero, para el correcto funcionamiento de la applicacion")
                .setPositiveButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setCancelable(false).show();

    }
}