package org.alan.mixdesign;
//-----------------------Dosificacion----------------------------
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.fonts.Font;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import org.w3c.dom.Document;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private static final int STORAGE_CODE =  1000;

    TextView titulo_1, titulo_2, titulo_3, titulo_4, titulo_5, titulo_6, titulo_7,titulo_8, titulo_9, titulo_10, titulo_11, titulo_12,
    titulo_13, titulo_14, titulo_15,
    //-----------------------------------------------
            view_1_1, view_1_2, view_1_3, view_1_4, view_1_5, view_1_6, view_2_1, view_3_1, view_4_1, view_5_1, view_6_1, view_7_1, view_7_2,
            view_8_1, view_8_2, view_8_3, view_8_4, view_9_1, view_9_2, view_9_3, view_9_4, view_9_5, view_9_6, view_10_1, view_10_2, view_11_1,
            view_11_2, view_11_3, view_11_4, view_11_5, view_11_6, view_12_1_0, view_12_1_1,view_12_1_2,view_12_2_0,view_12_2_1,view_12_2_2,
            view_12_3_0, view_12_3_1,view_12_3_2,view_12_3_3,view_12_3_4,view_12_4_0, view_12_4_1, view_12_4_2, view_12_4_3, view_12_4_5, view_12_4_6, view_12_4_4,
            view_13_1,view_13_2,view_13_3,view_13_4,view_13_5, view_14_1,view_14_2,view_14_3,view_14_4,view_14_5,
            view_15_1,view_15_2,view_15_3,view_15_4,view_15_5, view_15_6,view_15_7,

            mostrar_fact_modifi, mostrar_desviacion_estandar, mostrar_resistencia_promedio_requerida, valor_asentamiento,
            mostrar_resistencia_promedio_requerida_especificada, mostrar_ressi_prom_mod, mostrar_TMN_agre_gru, mostrar_peso_sec_comp_agre_gr,
            mostrar_volumen_unitario_de_agua, mostrar_aire_atrapado, mostrar_factor_cemento, mostrar_TMN_agre_gru_k, mostrar_cantidad_agregado_grueso,
            mostrar_fcr_agua_cemento_por_resistencia, mostrar_fcr_agua_cemento_por_durabilidad,
            mostrar_ac_de_diseño, mostrar_factor_cemento_v, mostrar_correccion_de_agua,
            mostrar_agua_paso9, mostrar_cemento_paso9, mostrar_aire_paso9, mostrar_v_a_g_paso9, mostrar_suma_paso9, mostrar_estado_paso9, mostrar_aditivo_paso9,
            mostrar_vol_a_f_paso9, mostrar_agua_paso11, mostrar_cemento_paso11, mostrar_aire_paso11, mostrar_v_a_g_paso11, mostrar_v_a_f_paso11, mostrar_aditivo11,
            mostrar_vol_paso10, mostrar_peso_paso10, mostrar_a_f_paso12, mostrar_a_g_paso12, mostrar_a_f_paso122, mostrar_agua_efectiva,
            mostrar_a_g_paso122, mostrar_a_f_paso123, mostrar_a_g_paso123, mostrar_cemento_paso12_4, mostrar_agua_paso12_4, mostrar_aire_paso12_4,
            mostrar_aditivo_paso_12_4, mostrar_a_f_paso12_4, mostrar_a_g_paso12_4, mostrar_cemento_paso13, mostrar_a_f_paso13, mostrar_a_g_paso13,
            mostrar_agua_paso13, mostrar_aditivo_paso13, mostrar_cemento_paso14, mostrar_a_f_paso14, mostrar_a_g_paso14,
            mostrar_agua_paso14, mostrar_aditivo_paso14, mostrar_cemento_paso15, mostrar_a_f_paso15, mostrar_a_g_paso15,
            mostrar_agua_paso15, mostrar_aditivo_paso15, mostrar_aire_paso15, mostrar_mezcla_necesaria_paso15, mostrar_bolsas;
    double valor_resis_dis1, valor_resis_dis2, d_valor_resis_dis1_F, fcr_a_c;
    double valor, aire_atrapado, d_cantidad_agre_grueso, v_f_c;

    String nombre_directorio = "Diseño de Mezcla";
    String nombre_documento = "informe.pdf";
    Button btngenerar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btngenerar = (Button) findViewById(R.id.generar_pdf);


        mostrar_fact_modifi = (TextView) findViewById(R.id.viewrfactor_de_modificacion);
        mostrar_desviacion_estandar = (TextView) findViewById(R.id.viewrdsde_la_constrtructora);
        mostrar_resistencia_promedio_requerida = (TextView) findViewById(R.id.viewresistencia_promedio_requerida);
        mostrar_resistencia_promedio_requerida_especificada = (TextView) findViewById(R.id.viewresistenciapormedio_especificada);
        valor_asentamiento = (TextView) findViewById(R.id.viewseleccionde_asentamiento);
        mostrar_ressi_prom_mod = (TextView) findViewById(R.id.viewresispromedio_modificado);
        mostrar_TMN_agre_gru = (TextView) findViewById(R.id.viewseleccionde_TMM);
        mostrar_TMN_agre_gru_k = (TextView) findViewById(R.id.viewTMNagreg_grue);
        mostrar_volumen_unitario_de_agua = (TextView) findViewById(R.id.viewvalor_del_volumen_unitario_agua);
        mostrar_aire_atrapado = (TextView) findViewById(R.id.viewvaireatrapado);
        mostrar_factor_cemento = (TextView) findViewById(R.id.viewvvol_agregado_grueso);
        mostrar_peso_sec_comp_agre_gr = (TextView) findViewById(R.id.viewpeso_unitario_seco_y_compactado);
        mostrar_cantidad_agregado_grueso = (TextView) findViewById(R.id.viewcantidad_del_agregado_grueso);
        mostrar_fcr_agua_cemento_por_resistencia = (TextView) findViewById(R.id.viewvrelacionAC_fcr_por_resistencia);
        mostrar_fcr_agua_cemento_por_durabilidad = (TextView) findViewById(R.id.viewvrelacionAC_fcr_por_durabilidad);
        mostrar_ac_de_diseño = (TextView) findViewById(R.id.viewvrelacionAC_sde_diseño);

        mostrar_factor_cemento_v = (TextView) findViewById(R.id.viewvafactor_cemento);
        mostrar_agua_paso9 = (TextView) findViewById(R.id.viewagua_paso9);
        mostrar_cemento_paso9 = (TextView) findViewById(R.id.viewcemento_paso9);
        mostrar_aire_paso9 = (TextView) findViewById(R.id.viewaire_paso9);
        mostrar_v_a_g_paso9 = (TextView) findViewById((R.id.viewagregado_grueso_paso9));
        mostrar_suma_paso9 = (TextView) findViewById(R.id.viewsuma_paso9);
        mostrar_estado_paso9 = (TextView) findViewById(R.id.viewestado_paso9);
        mostrar_aditivo_paso9 = (TextView) findViewById(R.id.viewotro_aditivo_paso9);

        mostrar_vol_paso10 = (TextView) findViewById(R.id.viewvolumen_paso10);
        mostrar_peso_paso10 = (TextView) findViewById(R.id.viewpeso_paso10);

        mostrar_agua_paso11 = (TextView) findViewById(R.id.viewagua_paso11);
        mostrar_cemento_paso11 = (TextView) findViewById(R.id.viewcemento_paso11);
        mostrar_aire_paso11 = (TextView) findViewById(R.id.viewaire_paso11);
        mostrar_v_a_g_paso11 = (TextView) findViewById((R.id.viewagregado_grueso_paso11));
        mostrar_v_a_f_paso11 = (TextView) findViewById((R.id.viewagregado_fino_paso11));
        mostrar_aditivo11 = (TextView) findViewById((R.id.viewotro_aditivo_paso11));

        mostrar_a_f_paso12 = (TextView) findViewById(R.id.viewa_f_paso12);
        mostrar_a_g_paso12 = (TextView) findViewById(R.id.view_a_g_paso12);

        mostrar_a_f_paso122 = (TextView) findViewById(R.id.viewa_f_paso12_2);
        mostrar_a_g_paso122 = (TextView) findViewById(R.id.view_a_g_paso12_2);

        mostrar_a_f_paso123 = (TextView) findViewById(R.id.viewa_f_paso12_3);
        mostrar_a_g_paso123 = (TextView) findViewById(R.id.view_a_g_paso12_3);

        mostrar_correccion_de_agua = (TextView) findViewById(R.id.view_correccion_de_agua);

        mostrar_agua_efectiva = (TextView) findViewById(R.id.view_agua_efectiva);

        mostrar_cemento_paso12_4 = (TextView) findViewById(R.id.view_cemento_paso12_4);
        mostrar_agua_paso12_4 = (TextView) findViewById(R.id.viewa_agua_paso12_4);
        mostrar_aire_paso12_4 = (TextView) findViewById(R.id.viewa_aire_paso12_4);
        mostrar_aditivo_paso_12_4 = (TextView) findViewById(R.id.viewaditivo_paso12_4);
        mostrar_a_f_paso12_4 = (TextView) findViewById(R.id.view_a_f_paso12_4);
        mostrar_a_g_paso12_4 = (TextView) findViewById(R.id.view_a_g_paso12_4);

        mostrar_cemento_paso13 = (TextView) findViewById(R.id.viewcemento_paso13);
        mostrar_a_f_paso13 = (TextView) findViewById(R.id.viewa_f_paso13);
        mostrar_a_g_paso13 = (TextView) findViewById(R.id.view_a_g_paso13);
        mostrar_agua_paso13 = (TextView) findViewById(R.id.view_agua_paso13);
        mostrar_aditivo_paso13 = (TextView) findViewById(R.id.view_aditivo_paso13);

        mostrar_cemento_paso14 = (TextView) findViewById(R.id.viewcemento_paso14);
        mostrar_a_f_paso14 = (TextView) findViewById(R.id.viewa_f_paso14);
        mostrar_a_g_paso14 = (TextView) findViewById(R.id.view_a_g_paso14);
        mostrar_agua_paso14 = (TextView) findViewById(R.id.view_agua_paso14);
        mostrar_aditivo_paso14 = (TextView) findViewById(R.id.view_aditivo_paso14);

        mostrar_cemento_paso15 = (TextView) findViewById(R.id.viewcemento_paso15);
        mostrar_a_f_paso15 = (TextView) findViewById(R.id.viewa_f_paso15);
        mostrar_a_g_paso15 = (TextView) findViewById(R.id.view_a_g_paso15);
        mostrar_agua_paso15 = (TextView) findViewById(R.id.view_agua_paso15);
        mostrar_aditivo_paso15 = (TextView) findViewById(R.id.view_aditivo_paso15);
        mostrar_aire_paso15 = (TextView) findViewById(R.id.view_aire_paso15);
        mostrar_bolsas = (TextView) findViewById(R.id.viewbolsas);

        mostrar_mezcla_necesaria_paso15 = (TextView) findViewById(R.id.view_mezcla_necearia_paso15);
//---------------------------------------------------------------------------------------------------
                titulo_1 = (TextView)findViewById(R.id.textView34);
                view_1_1 = (TextView)findViewById(R.id.textresistencia_promedio);
                view_1_2 = (TextView)findViewById(R.id.resistencia_del_diseño) ;
                view_1_3= (TextView)findViewById(R.id.desviacionestandar) ;
                view_1_4= (TextView)findViewById(R.id.view_1_4);
                view_1_5= (TextView)findViewById(R.id.view_5_1);
                view_1_6= (TextView)findViewById(R.id.view_6_1);

//---------------------------------------------------------------------------------------------------
                titulo_2 = (TextView)findViewById(R.id.tituloporceso_2);
                view_2_1 = (TextView)findViewById(R.id.textViewTMN);

//---------------------------------------------------------------------------------------------------
                titulo_3 = (TextView)findViewById(R.id.tituloporceso_3);
                view_3_1 = (TextView)findViewById(R.id.textViewasentamiento);
//---------------------------------------------------------------------------------------------------
                titulo_4 = (TextView)findViewById(R.id.tituloporceso);
                view_4_1 = (TextView)findViewById(R.id.textavolumenunitarioagua);
//---------------------------------------------------------------------------------------------------
                titulo_5 = (TextView)findViewById(R.id.titulocontenido_aire);
                view_5_1 = (TextView)findViewById(R.id.textaireatrapado);
//---------------------------------------------------------------------------------------------------
                titulo_6 = (TextView)findViewById(R.id.titulorelacionaAC);
                view_6_1 = (TextView)findViewById(R.id.textrelacionAC_diseño);
//---------------------------------------------------------------------------------------------------
                titulo_7 = (TextView)findViewById(R.id.titulofactor_cemento);
                view_7_1 =  (TextView)findViewById(R.id.textafactor_cemento);
                view_7_2 = (TextView)findViewById(R.id.bolsas);
//---------------------------------------------------------------------------------------------------
                titulo_8 = (TextView)findViewById(R.id.titulo_selec_agreg_grueso);
                view_8_1 = (TextView)findViewById(R.id.textfactor_cemento);
                view_8_2 = (TextView)findViewById(R.id.textvolumen_del_agregado_grueso);
                view_8_3  = (TextView)findViewById(R.id.peso_unitario_seco_y_compactado);
                view_8_4 = (TextView)findViewById(R.id.cantidad_del_agregado_grueso);
//---------------------------------------------------------------------------------------------------
                titulo_9 = (TextView)findViewById(R.id.titulo9);
                view_9_1 = (TextView)findViewById(R.id.textvalor_cemento);
                view_9_2 = (TextView)findViewById(R.id.textagua_paso9);
                view_9_3 = (TextView)findViewById(R.id.textaire_paso9);
                view_9_4 = (TextView)findViewById(R.id.agregado_grueso_paso9);
                view_9_5 = (TextView)findViewById(R.id.otro_aditivo);
                view_9_6 = (TextView)findViewById(R.id.suma);
//---------------------------------------------------------------------------------------------------
                titulo_10 = (TextView)findViewById(R.id.titulo_paso10);
                view_10_1 = (TextView)findViewById(R.id.volumen_paso9);
                view_10_2 = (TextView)findViewById(R.id.peso_paso10);
//---------------------------------------------------------------------------------------------------
                titulo_11= (TextView)findViewById(R.id.titulo_paso11);
                view_11_1 = (TextView)findViewById(R.id.textvalor_cemento);
                view_11_2 = (TextView)findViewById(R.id.textagua_paso9);
                view_11_3 = (TextView)findViewById(R.id.textaire_paso9);
                view_11_4 = (TextView)findViewById(R.id.agregado_grueso_paso9);
                view_11_5 = (TextView)findViewById(R.id.otro_aditivo);
                view_11_6 = (TextView)findViewById(R.id.otro_aditivo_11);
//---------------------------------------------------------------------------------------------------
                titulo_12 = (TextView)findViewById(R.id.titulo_paso12);
                view_12_1_0 = (TextView)findViewById(R.id.titulo_paso_12_1);
                view_12_1_1= (TextView)findViewById(R.id.a_f_paso12);
                view_12_1_2= (TextView)findViewById(R.id.text_a_g_paso12);
                view_12_2_0= (TextView)findViewById(R.id.titulo_paso_12_2);
                view_12_2_1= (TextView)findViewById(R.id.a_f_paso12_2);
                view_12_2_2= (TextView)findViewById(R.id.text_a_g_paso12_2);
                view_12_3_0= (TextView)findViewById(R.id.titulo_paso_12_3);
                view_12_3_1= (TextView)findViewById(R.id.a_f_paso12_3);
                view_12_3_2= (TextView)findViewById(R.id.text_a_g_paso12_3);
                view_12_3_3= (TextView)findViewById(R.id.text_correccion_de_agua);
                view_12_3_4= (TextView)findViewById(R.id.text_agua_efectiva);
                view_12_4_0 = (TextView)findViewById(R.id.titulo_paso_12_4);
                view_12_4_1 = (TextView)findViewById(R.id.a_cemento_paso12_4);
                view_12_4_2 = (TextView)findViewById(R.id.a_agua_paso12_4);
                view_12_4_3= (TextView)findViewById(R.id.a_aire_paso12_4);
                view_12_4_4 = (TextView)findViewById(R.id.a_aditivo_paso12_4);
                view_12_4_5= (TextView)findViewById(R.id.a_g_paso12_4);
                view_12_4_6= (TextView)findViewById(R.id.a_f_paso12_4);

//---------------------------------------------------------------------------------------------------
                titulo_13 = (TextView)findViewById(R.id.titulo_paso13);
                view_13_1= (TextView)findViewById(R.id.textvalor_cemento_13);
                view_13_2= (TextView)findViewById(R.id.texta_f_paso13);
                view_13_3= (TextView)findViewById(R.id.text_a_g_paso13);
                view_13_4= (TextView)findViewById(R.id.agua_paso13);
                view_13_5 = (TextView)findViewById(R.id.aditivo_paso13);
//---------------------------------------------------------------------------------------------------
                titulo_14 = (TextView)findViewById(R.id.titulo_paso14);
                view_14_1= (TextView)findViewById(R.id.textvalor_cemento_14);
                view_14_2= (TextView)findViewById(R.id.texta_f_paso14);
                view_14_3= (TextView)findViewById(R.id.text_a_g_paso14);
                view_14_4= (TextView)findViewById(R.id.agua_paso14);
                view_14_5 = (TextView)findViewById(R.id.aditivo_paso14);
//---------------------------------------------------------------------------------------------------
            titulo_15 = (TextView)findViewById(R.id.titulo_paso15);
            view_15_1= (TextView)findViewById(R.id.textvalor_mezcla_necesaria);
            view_15_2= (TextView)findViewById(R.id.textvalor_cemento_15);
            view_15_3= (TextView)findViewById(R.id.texta_f_paso15);
            view_15_4= (TextView)findViewById(R.id.text_a_g_paso15);
            view_15_5 = (TextView)findViewById(R.id.agua_paso15);
            view_15_6 = (TextView)findViewById(R.id.ire_paso15);
            view_15_7 = (TextView)findViewById(R.id.aditivo_paso15);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);

        createPDF();


        Intent intent = getIntent();

        double valor_des_est = intent.getDoubleExtra("desviacion estandar", 0);
        double valor_num_ensayos = intent.getDoubleExtra("nº de ensayos", 0);
        double valor_resis_dis = intent.getDoubleExtra("resis diseño", 0);
        String TMN = intent.getStringExtra("TMN");
        String paso_valor_asentamiento = intent.getStringExtra("asentamiento");
        String aire = intent.getStringExtra("selec_aire");
        String tipo_expo = intent.getStringExtra("tipo_expo");
        double modulo_ag_grueso = intent.getDoubleExtra("modulo_ag_grueso", 0);
        String peso_unit_com_agre_grueso = intent.getStringExtra("peso_sc_agre_grueso");
        double d_peso_sc_agre_grueso = intent.getDoubleExtra("d_peso_sc_agre_grueso", 0);
        double ac_durabildiad = intent.getDoubleExtra("valor_ac", 0.0);
        String espe_tipo_expo = intent.getStringExtra("espe_tipo_espo");
        double p_e_a_f = intent.getDoubleExtra("p_e_a_f", 0);
        double h_a_f = intent.getDoubleExtra("h_a_f", 0);
        double h_a_g = intent.getDoubleExtra("h_a_g", 0);
        double ab_a_g = intent.getDoubleExtra("ab_a_g", 0);
        double ab_a_f = intent.getDoubleExtra("ab_a_f", 0);
        double aditivoxbls = intent.getDoubleExtra("aditivoxbls", 0);
        double p_e_aditivo = intent.getDoubleExtra("p_e_aditivo", 0);
        double mezcla_necesaria = intent.getDoubleExtra("mezcla_necesaria", 0);

        double p_e_a_g = intent.getDoubleExtra("d_peso_e_a_g", 0);

        double d_p_c = intent.getDoubleExtra("d_p_c", 0);
        //  Toast.makeText(this, " pasa  " +  mezcla_necesaria, Toast.LENGTH_LONG).show();

        //----------escribir desviacion estandar--------------------//
        String str_valor_des_est = String.valueOf(valor_des_est);
        mostrar_desviacion_estandar.setText(str_valor_des_est);

        //---------escribir resis promedi req espe ----------------//
        String str_resis_dis = String.valueOf(valor_resis_dis);
        mostrar_resistencia_promedio_requerida_especificada.setText(str_resis_dis);

        //---- paso 2 leer agregado grueso
        mostrar_TMN_agre_gru.setText(TMN);
        mostrar_TMN_agre_gru_k.setText(TMN);

        //cunado no hay desviacion estandar
        if (valor_des_est == 0) {
            mostrar_fact_modifi.setText("No hay valor");
            if (valor_resis_dis < 210) {
                d_valor_resis_dis1_F = valor_resis_dis + 70;
                String str_valor_resis_dis = String.valueOf(d_valor_resis_dis1_F);
                mostrar_resistencia_promedio_requerida.setText(str_valor_resis_dis);
                mostrar_ressi_prom_mod.setText(str_valor_resis_dis);

            }
            if (valor_resis_dis >= 210 && valor_resis_dis <= 350.0) {
                d_valor_resis_dis1_F = valor_resis_dis + 85;
                String str_valor_resis_dis = String.valueOf(d_valor_resis_dis1_F);
                mostrar_resistencia_promedio_requerida.setText(str_valor_resis_dis);
                mostrar_ressi_prom_mod.setText(str_valor_resis_dis);
            }
            if (valor_resis_dis > 350) {
                d_valor_resis_dis1_F = 1.1 * valor_resis_dis + 50;
                String str_valor_resis_dis = String.valueOf(d_valor_resis_dis1_F);
                mostrar_resistencia_promedio_requerida.setText(str_valor_resis_dis);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", d_valor_resis_dis1_F));
            }
        }
        //cuando si hay desviacion standar
        if (valor_des_est > 0) {
            if (valor_num_ensayos == 15) {
                double fact_modificacion = 1.16;
                String fact_modificacion_str = String.valueOf(fact_modificacion);
                mostrar_fact_modifi.setText(fact_modificacion_str);

                double resis_prom_modifi = fact_modificacion * valor_resis_dis;
                String string_resis_pro_mo = String.valueOf(resis_prom_modifi);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", resis_prom_modifi));

                if (valor_resis_dis <= 350.0) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (2.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }

                }
            }
            if (valor_num_ensayos == 20) {
                double fact_modificacion = 1.08;
                String str_fact_modificacion = String.valueOf(fact_modificacion);
                mostrar_fact_modifi.setText(str_fact_modificacion);

                double resis_prom_modifi = fact_modificacion * valor_resis_dis;
                String string_resis_pro_mo = String.valueOf(resis_prom_modifi);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", resis_prom_modifi));
                if (valor_resis_dis <= 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (1.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
            }
            if (valor_num_ensayos == 25) {
                double fact_modificacion = 1.03;
                String str_fact_modificacion = String.valueOf(fact_modificacion);
                mostrar_fact_modifi.setText(str_fact_modificacion);

                double resis_prom_modifi = fact_modificacion * valor_resis_dis;
                String string_resis_pro_mo = String.valueOf(resis_prom_modifi);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", resis_prom_modifi));
                if (valor_resis_dis <= 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (1.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
            }
            if (valor_num_ensayos == 30 || valor_num_ensayos > 30 || valor_num_ensayos < 15) {
                double fact_modificacion = 1.00;
                String str_fact_modificacion = String.valueOf(fact_modificacion);
                mostrar_fact_modifi.setText(str_fact_modificacion);

                double resis_prom_modifi = fact_modificacion * valor_resis_dis;
                String string_resis_pro_mo = String.valueOf(resis_prom_modifi);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", resis_prom_modifi));
                if (valor_resis_dis <= 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (1.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
            }
            if (valor_num_ensayos > 15 && valor_num_ensayos < 20) {
                double fact_modificacion_c1 = 1.16 + ((1.08 - 1.16) / (20 - 15)) * (valor_num_ensayos - 15);
                String str_fact_modificacion = String.valueOf(fact_modificacion_c1);
                mostrar_fact_modifi.setText(String.format("%.2f", str_fact_modificacion));

                double resis_prom_modifi = fact_modificacion_c1 * valor_resis_dis;
                String string_resis_pro_mo = String.valueOf(resis_prom_modifi);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", resis_prom_modifi));

                if (valor_resis_dis <= 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (1.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
            }
            if (valor_num_ensayos > 20 && valor_num_ensayos < 25) {
                double fact_modificacion_c1 = 1.08 + ((1.03 - 1.08) / (25 - 20)) * (valor_num_ensayos - 20);
                String str_fact_modificacion = String.valueOf(fact_modificacion_c1);
                mostrar_fact_modifi.setText(String.format("%.2f", fact_modificacion_c1));

                double resis_prom_modifi = fact_modificacion_c1 * valor_resis_dis;
                String string_resis_pro_mo = String.valueOf(resis_prom_modifi);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", resis_prom_modifi));

                if (valor_resis_dis <= 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (1.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
            }
            if (valor_num_ensayos > 25 && valor_num_ensayos < 30) {
                double fact_modificacion_c1 = 1.03 + ((1.00 - 1.03) / (25 - 20)) * (valor_num_ensayos - 25);
                String str_fact_modificacion = String.valueOf(fact_modificacion_c1);
                mostrar_fact_modifi.setText(String.format("%.2f", fact_modificacion_c1));

                if (valor_resis_dis <= 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (1.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
            }
            if (valor_num_ensayos > 30) {
                double fact_modificacion_c1 = 1.00;
                String str_fact_modificacion = String.valueOf(fact_modificacion_c1);
                mostrar_fact_modifi.setText(str_fact_modificacion);

                double resis_prom_modifi = fact_modificacion_c1 * valor_resis_dis;
                String string_resis_pro_mo = String.valueOf(resis_prom_modifi);
                mostrar_ressi_prom_mod.setText(String.format("%.2f", resis_prom_modifi));

                if (valor_resis_dis <= 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = valor_resis_dis + (1.33 * valor_des_est) - 35;
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
                if (valor_resis_dis > 350) {
                    valor_resis_dis1 = valor_resis_dis + (1.34 * valor_des_est);
                    valor_resis_dis2 = 0.90 * valor_resis_dis + (2.33 * valor_des_est);
                    if (valor_resis_dis1 > valor_resis_dis2) {
                        d_valor_resis_dis1_F = valor_resis_dis1;
                        String str_valor_resis_dis1_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                    if (valor_resis_dis2 > valor_resis_dis1) {
                        d_valor_resis_dis1_F = valor_resis_dis2;
                        String str_valor_resis_dis2_F = String.valueOf(d_valor_resis_dis1_F);
                        mostrar_resistencia_promedio_requerida.setText(String.format("%.2f", d_valor_resis_dis1_F));
                    }
                }
            }

        }
//------------------------seleccion paso 3--------------------------------------------------------7//
        if (paso_valor_asentamiento.equals("Seco")) {
            valor_asentamiento.setText("1'' a 2''");
        }
        if (paso_valor_asentamiento.equals("Plastico")) {
            valor_asentamiento.setText("3'' a 4''");
        }
        if (paso_valor_asentamiento.equals("Fluido")) {
            valor_asentamiento.setText("6'' a 7''");
        }
        if (paso_valor_asentamiento.equals("No se tiene")) {
            valor_asentamiento.setText("3''");
        }
//-----------------------------------------------------------------------------------------------//
//------------------paso 4--------------------------------------------------------------//
        //-----concreto Sin aire incorporado-------//
        if (aire.equals("Sin aire")) {
            //-------------------"1'' a 2''"
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("3/8''")) {
                valor = 207;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("1/2''")) {
                valor = 199;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("3/4''")) {
                valor = 190;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("1''")) {
                valor = 179;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("1 1/2''")) {
                valor = 166;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("2''")) {
                valor = 154;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("3''")) {
                valor = 130;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("6''")) {
                valor = 113;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            //-------------------"3'' a 4''"----------------------------
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("3/8''")) {
                valor = 228;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("1/2''")) {
                valor = 216;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("3/4''")) {
                valor = 205;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("1''")) {
                valor = 193;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("1 1/2''")) {
                valor = 181;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("2''")) {
                valor = 169;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("3''")) {
                valor = 145;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("6''")) {
                valor = 124;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            //-------------------"3'' a 4''"----------------------------

            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("3/8''")) {
                valor = 243;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("1/2''")) {
                valor = 228;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("3/4''")) {
                valor = 216;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("1''")) {
                valor = 202;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("1 1/2''")) {
                valor = 190;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("2''")) {
                valor = 178;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("3''")) {
                valor = 160;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("6''")) {
                String valor = "---";
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
        }
        // ----------con aire incorporado"---------
        if (aire.equals("Con aire")) {
            //-------------------"1'' a 2''"
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("3/8''")) {
                valor = 181;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("1/2''")) {
                valor = 175;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("3/4''")) {
                valor = 168;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("1''")) {
                valor = 160;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("1 1/2''")) {
                valor = 150;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("2''")) {
                valor = 142;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("3''")) {
                valor = 122;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "1'' a 2''" && TMN.equals("6''")) {
                valor = 107;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            //  ---------------"3'' a 4''"----------------------------//
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("3/8''")) {
                valor = 202;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("1/2''")) {
                valor = 193;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("3/4''")) {
                valor = 184;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("1''")) {
                valor = 175;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("1 1/2''")) {
                valor = 165;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("2''")) {
                valor = 157;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("3''")) {
                valor = 133;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "3'' a 4''" && TMN.equals("6''")) {
                valor = 119;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }

            //-------------------"6'' a 7''"----------------------------

            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("3/8''")) {
                valor = 216;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("1/2''")) {
                valor = 205;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("3/4''")) {
                valor = 197;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("1''")) {
                valor = 184;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("1 1/2''")) {
                valor = 174;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("2''")) {
                valor = 166;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("3''")) {
                valor = 154;
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
            if (valor_asentamiento.getText() == "6'' a 7''" && TMN.equals("6''")) {
                String valor = "---";
                mostrar_volumen_unitario_de_agua.setText(valor + "  Lts");
            }
        }
//--------------------------------------------------------------------------------------------------

//------------------------------paso 5----------------------------------------------------------/
//-------------------------contenido con aire atrapado------------------------------------//
        if (aire.equals("Sin aire")) {
            if (TMN.equals("3/8''")) {
                aire_atrapado = 3.0;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
            if (TMN.equals("1/2''")) {
                aire_atrapado = 2.5;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
            if (TMN.equals("3/4''")) {
                aire_atrapado = 2;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
            if (TMN.equals("1''")) {
                aire_atrapado = 1.5;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
            if (TMN.equals("1 1/2''")) {
                aire_atrapado = 1;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
            if (TMN.equals("2''")) {
                aire_atrapado = 0.5;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
            if (TMN.equals("3''")) {
                aire_atrapado = 0.3;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
            if (TMN.equals("6''")) {
                aire_atrapado = 0.2;
                mostrar_aire_atrapado.setText(aire_atrapado + " %");
            }
        }
//-----------------------------Contenido Con aire atrapado----------------------------------------//
        if (aire.equals("Con aire")) {
            if (TMN.equals("3/8''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 3.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 4.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 6.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 7.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
            }
            if (TMN.equals("1/2''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 2.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 4.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 5.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 7.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
            }
            if (TMN.equals("3/4''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 2.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 3.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 5.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 6.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
            }
            if (TMN.equals("1''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 1.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 3.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 4.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 6.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
            }
            if (TMN.equals("1 1/2''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 1.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 2.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 4.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 5.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }

            }
            if (TMN.equals("2''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 0.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 2.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 4.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 5.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
            }
            if (TMN.equals("3''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 0.3;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 1.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 3.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 4.5;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
            }
            if (TMN.equals("6''")) {
                if (espe_tipo_expo != "Suave" || espe_tipo_expo != "Moderada" || espe_tipo_expo != "Severa") {
                    aire_atrapado = 0.2;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Suave")) {
                    aire_atrapado = 1.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Moderada")) {
                    aire_atrapado = 3.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
                if (espe_tipo_expo.equals("Severa")) {
                    aire_atrapado = 4.0;
                    mostrar_aire_atrapado.setText(aire_atrapado + " %");
                }
            }

        }

//------------------------------------------------------------------------------------------------//

//-----------------------Fio - 1 ---------------------------------------------------------------------
        //--------------------------diseño por resistencia--------------------------------------------------
        //-------------con aire-----//

        if (d_valor_resis_dis1_F == 150 && aire.equals("Con aire")) {
            fcr_a_c = 0.71;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.71");
        }

        if (d_valor_resis_dis1_F > 150 && d_valor_resis_dis1_F < 200 && aire.equals("Con aire")) {
            fcr_a_c = 0.71 + ((0.61 - 0.71) / (200 - 150)) * (d_valor_resis_dis1_F - 150);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 200 && aire.equals("Con aire")) {
            fcr_a_c = 0.61;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.61");
        }

        if (d_valor_resis_dis1_F > 200 && d_valor_resis_dis1_F < 250 && aire.equals("Con aire")) {
            fcr_a_c = 0.61 + ((0.53 - 0.61) / (250 - 200)) * (d_valor_resis_dis1_F - 200);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 250 && aire.equals("Con aire")) {
            fcr_a_c = 0.53;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.53");
        }

        if (d_valor_resis_dis1_F > 250 && d_valor_resis_dis1_F < 300 && aire.equals("Con aire")) {
            fcr_a_c = 0.53 + ((0.46 - 0.53) / (300 - 250)) * (d_valor_resis_dis1_F - 250);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 300 && aire.equals("Con aire")) {
            fcr_a_c = 0.46;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.46");
        }

        if (d_valor_resis_dis1_F > 300 && d_valor_resis_dis1_F < 350 && aire.equals("Con aire")) {
            fcr_a_c = 0.46 + ((0.4 - 0.46) / (350 - 300)) * (d_valor_resis_dis1_F - 300);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 350 && aire.equals("Con aire")) {
            fcr_a_c = 0.4;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.4");
        }

        if (d_valor_resis_dis1_F > 350 && d_valor_resis_dis1_F < 400 && aire.equals("Con aire")) {
            fcr_a_c = 0.4 + ((0.35 - 0.4) / (400 - 350)) * (d_valor_resis_dis1_F - 350);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }
        if (d_valor_resis_dis1_F == 400 && aire.equals("Con aire")) {
            fcr_a_c = 0.35;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.35");
        }

        if (d_valor_resis_dis1_F > 400 && d_valor_resis_dis1_F < 450 && aire.equals("Con aire")) {
            fcr_a_c = 0.35 + ((0.3 - 0.35) / (450 - 400)) * (d_valor_resis_dis1_F - 400);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 450 && aire.equals("Con aire")) {
            fcr_a_c = 0.3;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.3");

        }
        if (aire.equals("Con aire")) {
            String s_fcr_a_c = mostrar_fcr_agua_cemento_por_resistencia.getText().toString();
            double n_fcr_a_c = Double.parseDouble(s_fcr_a_c);
            // Toast.makeText(this, " valor " + fcr_a_c + ac_durabildiad, Toast.LENGTH_LONG).show();
            if (fcr_a_c < ac_durabildiad) {
                double seleccion_ac = n_fcr_a_c;
                mostrar_ac_de_diseño.setText(String.format("%.2f", seleccion_ac));
                double a_c = (valor / seleccion_ac);
                mostrar_factor_cemento_v.setText(String.format("%.2f", a_c));
                String s_a_c = String.valueOf(a_c);
                mostrar_ac_de_diseño.setText(String.format("%.2f", seleccion_ac));
                mostrar_factor_cemento_v.setText(String.format("%.2f", a_c));
                  // Toast.makeText(this, " seleccion  " + a_c, Toast.LENGTH_LONG).show();

            }  else if (fcr_a_c > ac_durabildiad) {
                double seleccion_ac = ac_durabildiad;
                mostrar_ac_de_diseño.setText(String.format("%.2f", seleccion_ac));
                double a_c = (valor / seleccion_ac);
                mostrar_ac_de_diseño.setText(String.format("%.2f", ac_durabildiad));
                 //Toast.makeText(this, " seleccion  " + a_c, Toast.LENGTH_LONG).show();

            }
        }

        //-------------sin aire-----------------------//


        if (d_valor_resis_dis1_F == 150 && aire.equals("Sin aire")) {
            fcr_a_c = 0.80;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.80");
        }

        if (d_valor_resis_dis1_F > 150 && d_valor_resis_dis1_F < 200 && aire.equals("Sin aire")) {
            fcr_a_c = 0.8 + ((0.7 - 0.8) / (200 - 150)) * (d_valor_resis_dis1_F - 150);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 200 && aire.equals("Sin aire")) {
            fcr_a_c = 0.70;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.70");
        }

        if (d_valor_resis_dis1_F > 200 && d_valor_resis_dis1_F < 250 && aire.equals("Sin aire")) {
            fcr_a_c = 0.70 + ((0.62 - 0.7) / (250 - 200)) * (d_valor_resis_dis1_F - 200);
            String str_fcr_a_c = String.valueOf(fcr_a_c);

            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 250 && aire.equals("Sin aire")) {
            fcr_a_c = 0.62;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.62");
        }

        if (d_valor_resis_dis1_F > 250 && d_valor_resis_dis1_F < 300 && aire.equals("Sin aire")) {
            fcr_a_c = 0.62 + ((0.55 - 0.62) / (300 - 250)) * (d_valor_resis_dis1_F - 250);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 300 && aire.equals("Sin aire")) {
            fcr_a_c = 0.55;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.55");
        }

        if (d_valor_resis_dis1_F > 300 && d_valor_resis_dis1_F < 350 && aire.equals("Sin aire")) {
            fcr_a_c = 0.55 + ((0.48 - 0.55) / (350 - 300)) * (d_valor_resis_dis1_F - 300);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 350 && aire.equals("Sin aire")) {
            fcr_a_c = 0.48;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.48");
        }

        if (d_valor_resis_dis1_F > 350 && d_valor_resis_dis1_F < 400 && aire.equals("Sin aire")) {
            fcr_a_c = 0.48 + ((0.43 - 0.48) / (400 - 350)) * (d_valor_resis_dis1_F - 350);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }
        if (d_valor_resis_dis1_F == 400 && aire.equals("Sin aire")) {
            fcr_a_c = 0.43;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.43");
        }

        if (d_valor_resis_dis1_F > 400 && d_valor_resis_dis1_F < 450 && aire.equals("Sin aire")) {
            fcr_a_c = 0.43 + ((0.38 - 0.43) / (450 - 400)) * (d_valor_resis_dis1_F - 400);
            String str_fcr_a_c = String.valueOf(fcr_a_c);
            mostrar_fcr_agua_cemento_por_resistencia.setText(String.format("%.2f", fcr_a_c));
        }

        if (d_valor_resis_dis1_F == 450 && aire.equals("Sin aire")) {
            fcr_a_c = 0.38;
            mostrar_fcr_agua_cemento_por_resistencia.setText("0.38");
        }

        //--------------------diseño por durabilidad------------------------

        mostrar_fcr_agua_cemento_por_durabilidad.setText((String.format("%.2f", ac_durabildiad)));

        //----------------------agua cemento de diseño y paso 7-----------------------//
        if (aire.equals("Sin aire")) {
            String s_ac_resistencia = mostrar_fcr_agua_cemento_por_resistencia.getText().toString();
            double d_ac_resistencia_sinaire = Double.parseDouble(s_ac_resistencia);
            mostrar_factor_cemento_v.setText(String.format("%.2f", fcr_a_c));
            double r_ac_diseño_paso6 = valor / d_ac_resistencia_sinaire;

            mostrar_factor_cemento_v.setText(String.format("%.2f", r_ac_diseño_paso6));
            mostrar_ac_de_diseño.setText(String.format("%.2f", fcr_a_c));

        }



        String s_paso7 = mostrar_factor_cemento_v.getText().toString();
        Double d_paso7 = Double.parseDouble(s_paso7);



        double r_paso_7 = d_paso7 / 42.5;
        int redondeo_bolsa_paso7 = (int) Math.round(r_paso_7);

        mostrar_bolsas.setText("" + redondeo_bolsa_paso7);

//------------------------------------------------------------------------------------------------//
//----------------------------K G-----------------------------------------------------------------//
        //agregado grueo------------------------------------------------------------------------//
        if (TMN.equals("3/8''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.50;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.50 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));

        }
        if (TMN.equals("3/8''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            v_f_c = 0.50 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.48 - 0.50);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));


            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/8''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.48;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.48 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("3/8''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            v_f_c = 0.48 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.46 - 0.48);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/8''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.46;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.46 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/8''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            v_f_c = 0.46 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.44 - 0.46);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/8''") && modulo_ag_grueso >= 3.0) {
            v_f_c = 0.44;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.44 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));

        }
        if (TMN.equals("1/2''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.59;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.59 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            v_f_c = 0.59 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.57 - 0.59);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.57;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.57 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            v_f_c = 0.57 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.55 - 0.57);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.55;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.55 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            v_f_c = 0.55 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.53 - 0.55);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso >= 3.00) {
            v_f_c = 0.53;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.53 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("3/4''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.66;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.66 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {

            v_f_c = 0.66 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.64 - 0.66);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));


            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.64;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.64 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {

            v_f_c = 0.64 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.62 - 0.64);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.62;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.62 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {

            v_f_c = 0.62 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.60 - 0.62);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso >= 3.00) {
            v_f_c = 0.60;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.60 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("1''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.71;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.71 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {

            v_f_c = 0.71 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.69 - 0.71);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.69;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.69 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {

            v_f_c = 0.69 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.67 - 0.69);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.67;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.67 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            v_f_c = 0.67 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.65 - 0.67);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso >= 3.00) {
            v_f_c = 0.65;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.65 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }


        if (TMN.equals("1 1/2''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.76;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.76 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            v_f_c = 0.76 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.74 - 0.76);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.74;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.74 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.73 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.74 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.72 - 0.74);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.72;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.72 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.71 + (3.00 - modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.72 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.70 - 0.72);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.3f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso >= 3.00) {
            v_f_c = 0.70;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("2''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.78;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.78 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            //v_f_c = 0.78 + (2.60 - modulo_ag_grueso) / (modulo_ag_grueso - 2.40) * (modulo_ag_grueso - 2.40);
            v_f_c = 0.78 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.76 - 0.78);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.76;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));
            ;

            d_cantidad_agre_grueso = 0.76 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));

        }
        if (TMN.equals("2''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.76 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.76 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.74 - 0.76);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(str_cantidad_agreg_grueso);
        }
        if (TMN.equals("2''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.74;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.74 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.74 + (3.00 - modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.74 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.72 - 0.74);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso >= 3.00) {
            v_f_c = 0.72;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.72 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("3''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.82;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.82 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            //v_f_c = 0.82 + (2.60 - modulo_ag_grueso) / (modulo_ag_grueso - 2.40) * (modulo_ag_grueso - 2.40);
            v_f_c = 0.82 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.80 - 0.82);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.80;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.80 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.80 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.80 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.78 - 0.80);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.78;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.78 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.78 + (3.00 -modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.78 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.76 - 0.78);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso >= 3.00) {
            v_f_c = 0.76;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.76 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("6''") && modulo_ag_grueso <= 2.40) {
            v_f_c = 0.87;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.87 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            //v_f_c = 0.87 + (2.60 - modulo_ag_grueso) / (modulo_ag_grueso - 2.40) * (modulo_ag_grueso - 2.40);
            v_f_c = 0.87 + (modulo_ag_grueso - 2.40) / (2.60 - 2.40) * (0.85 - 0.87);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso == 2.60) {
            v_f_c = 0.85;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.85 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.85 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.85 + (modulo_ag_grueso - 2.60) / (2.80 - 2.60) * (0.83 - 0.85);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso == 2.80) {
            v_f_c = 0.83;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.83 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.80 + (3.00 - modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.80 + (modulo_ag_grueso - 2.80) / (3.00 - 2.80) * (0.81 - 0.83);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc = Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            ;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso >= 3.00) {
            v_f_c = 0.81;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.81 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        //-----mostrar agreg grueso------//
        mostrar_peso_sec_comp_agre_gr.setText(peso_unit_com_agre_grueso);

        //---------------paso 9------------------------//

        String s_cemento_paso7 = mostrar_factor_cemento_v.getText().toString();
        double d_cemento_paso7 = Double.parseDouble(s_cemento_paso7);
        double cemento = d_cemento_paso7 / d_p_c;
        mostrar_cemento_paso9.setText(String.format("%.3f", cemento));
        double agua_paso_9 = valor / 1000;
        mostrar_agua_paso9.setText(String.format("%.3f", agua_paso_9));
        double aire_paso9 = aire_atrapado / 100;

        String s_a_g_paso8 = mostrar_cantidad_agregado_grueso.getText().toString();
        double d_a_g_paso8 = Double.parseDouble(s_a_g_paso8);

        mostrar_aire_paso9.setText(String.format("%.3f", aire_paso9));
        double v_a_g_paso9 = d_a_g_paso8 / p_e_a_g;
        mostrar_v_a_g_paso9.setText(String.format("%.3f", v_a_g_paso9));

        // Toast.makeText(this, " pasa  " +  d_a_g_paso8 + p_e_a_g, Toast.LENGTH_LONG).show();
        String s_f_c = mostrar_factor_cemento_v.getText().toString();
        double d_f_c = Double.parseDouble(s_f_c);
        double aditivo = (redondeo_bolsa_paso7 * aditivoxbls) / 1000000;
        mostrar_aditivo_paso9.setText(String.format("%.5f", aditivo));
        double suma = cemento + agua_paso_9 + aire_paso9 + v_a_g_paso9 + aditivo;

        mostrar_suma_paso9.setText(String.format("%.3f", suma));

        if (suma < 1.0) {
            String no_aceptado = "<font color='#EE0000'> </font>";
            mostrar_estado_paso9.setText(Html.fromHtml(no_aceptado));

        } else if (suma >= 1.0) {
            String aceptado = "<font color='#FFFFFF'> </font>";
            mostrar_estado_paso9.setText(Html.fromHtml(aceptado));
        }


        //------------paso 10------------------------//
        double v_a_F = 1.0 - suma;
        mostrar_vol_paso10.setText(String.format("%.3f", v_a_F));
        String s_v_a_f = mostrar_vol_paso10.getText().toString();
        double d_v_a_f = Double.parseDouble(s_v_a_f);
        double peso_paso10 = d_v_a_f * p_e_a_f;
        mostrar_peso_paso10.setText(String.format("%.2f", peso_paso10));

        //------------paso11--------------------------//
        String c_11 = mostrar_factor_cemento_v.getText().toString();
        //double cemento_11 =  valor /0.557;
        double agua_paso_11 = valor;
        double aire_paso11 = aire_atrapado;
        double v_a_g_paso11 = (d_peso_sc_agre_grueso * v_f_c);
        String adtivo_paso9 = mostrar_aditivo_paso9.getText().toString();
        double d_aditivo_paso9 = Double.parseDouble(adtivo_paso9);
        double aditivo_paso11 = d_aditivo_paso9 * p_e_aditivo;

        mostrar_cemento_paso11.setText(c_11);
        mostrar_agua_paso11.setText(String.format("%.2f", agua_paso_11));
        mostrar_aire_paso11.setText(String.format("%.2f", aire_paso11));
        mostrar_v_a_g_paso11.setText(String.format("%.2f", v_a_g_paso11));
        mostrar_v_a_f_paso11.setText(String.format("%.2f", peso_paso10));
        mostrar_aditivo11.setText(String.format("%.2f", aditivo_paso11));

        //------------paso12--------------------------------//
        double a_f_paso12 = peso_paso10 * (1 + (h_a_f / 100));
        mostrar_a_f_paso12.setText(String.format("%.2f", a_f_paso12));

        String s_a_g_paso11 = mostrar_v_a_g_paso11.getText().toString();
        double d_a_g_paso11 = Double.parseDouble(s_a_g_paso11);
        double a_g_paso12 = d_a_g_paso11 * (1 + (h_a_g / 100));
        mostrar_a_g_paso12.setText(String.format("%.2f", a_g_paso12));

        //------------paso12.2--------------------------------//

        double a_f_paso122 = h_a_f - ab_a_f;
        mostrar_a_f_paso122.setText(String.format("%.2f", a_f_paso122));

        double a_g_paso12_2 = h_a_g - ab_a_g;
        mostrar_a_g_paso122.setText(String.format("%.2f", a_g_paso12_2));

        //------------paso12.3--------------------------------//
        String s_peso_paso10 = mostrar_v_a_f_paso11.getText().toString();
        double n_peso_paso10 = Double.parseDouble(s_peso_paso10);

        String s_a_f_paso122 = mostrar_a_f_paso122.getText().toString();
        double n_a_f_paso122 = Double.parseDouble(s_a_f_paso122);

        double a_f_paso12_3 = (n_peso_paso10 * n_a_f_paso122) / 100;
        mostrar_a_f_paso123.setText(String.format("%.2f", a_f_paso12_3));

        String s_v_a_g_paso11 = mostrar_v_a_g_paso11.getText().toString();
        double n_v_a_g_paso11 = Double.parseDouble(s_v_a_g_paso11);

        String s_a_g_paso122 = mostrar_a_g_paso122.getText().toString();
        double n_a_g_paso122 = Double.parseDouble(s_a_g_paso122);

        double a_g_paso12_3 = (n_a_g_paso122 * n_v_a_g_paso11) / 100;
        mostrar_a_g_paso123.setText(String.format("%.2f", a_g_paso12_3));
        //-------mostarr correccion de agua---------//

        String s_a_f_correc_agua = mostrar_a_f_paso123.getText().toString();
        double d_a_f_correc_agua = Double.parseDouble(s_a_f_correc_agua);

        String s_a_g_correc_agua = mostrar_a_g_paso123.getText().toString();
        double d_a_g_correc_agua = Double.parseDouble(s_a_g_correc_agua);


        double correccion_de_agua = d_a_f_correc_agua + d_a_g_correc_agua;
        mostrar_correccion_de_agua.setText(String.format("%.2f", correccion_de_agua));


        //----------mostarar agua efectiva ----//
        String s_correccion_agua_ = mostrar_correccion_de_agua.getText().toString();
        double d_correccion_agua = Double.parseDouble(s_correccion_agua_);

        if (d_correccion_agua > 0.0) {
            double a_f = valor - d_correccion_agua;
            mostrar_agua_efectiva.setText(String.format("%.2f", a_f));
        } else if (d_correccion_agua < 0.0) {
            double a_f = valor - d_correccion_agua;
            mostrar_agua_efectiva.setText(String.format("%.2f", a_f));
        }

        //Toast.makeText(this, " v_f_c  "+ n_peso_paso10 +"  "+ n_a_f_paso122 , Toast.LENGTH_LONG).show();

        //valores corregidos por humedad

        String cemento_correc_huem = mostrar_factor_cemento_v.getText().toString();
        double d_cemento_correc_huem = Double.parseDouble(cemento_correc_huem);
        mostrar_cemento_paso12_4.setText(String.format("%.2f", d_cemento_correc_huem));

        String agua_efec = mostrar_agua_efectiva.getText().toString();
        double d_agua_efec = Double.parseDouble(agua_efec);
        int redondeo_agua_paso12_4 = (int) Math.round(d_agua_efec);
//        mostrar_agua_paso12_4.setText(String.format("%.2f", d_agua_efec));
        mostrar_agua_paso12_4.setText("" + redondeo_agua_paso12_4);

        //String aire_12_4 = mostrar_aire_atrapado.getText().toString();
        //double d_aire_12_4 = Double.parseDouble(aire_12_4);
        int redondeo_aire_paso12_4 = (int) Math.round(aire_atrapado);
        //mostrar_aire_paso12_4.setText(String.format("%.2f",aire_atrapado));
        mostrar_aire_paso12_4.setText("" + redondeo_aire_paso12_4);

        String s_a_g_12_4 = mostrar_a_g_paso12.getText().toString();
        double d_a_g_12_4 = Double.parseDouble(s_a_g_12_4);
        int redondeo_a_g_paso12_4 = (int) Math.round(d_a_g_12_4);
        //mostrar_a_g_paso12_4.setText(String.format("%.2f",d_a_g_12_4));
        mostrar_a_g_paso12_4.setText("" + redondeo_a_g_paso12_4);

        String s_a_f_12_4 = mostrar_a_f_paso12.getText().toString();
        double d_a_f_12_4 = Double.parseDouble(s_a_f_12_4);
        int redondeo_a_f_paso12_4 = (int) Math.round(d_a_f_12_4);
        //mostrar_a_f_paso12_4.setText(String.format("%.2f",d_a_f_12_4));
        mostrar_a_f_paso12_4.setText("" + redondeo_a_f_paso12_4);

        int redondeo_aditivo_paso12_4 = (int) Math.round(aditivo_paso11);
        //mostrar_aditivo_paso_12_4.setText(String.format("%.2f", aditivo_paso11));
        mostrar_aditivo_paso_12_4.setText("" + redondeo_aditivo_paso12_4);

        //------------------------------paso13--------------------------//
        double cemento_paso13 = 1.00;
        mostrar_cemento_paso13.setText(String.format("%.2f", cemento_paso13));

        String s_cemento_paso12_4 = mostrar_cemento_paso12_4.getText().toString();
        double d_cemento_paso12_4 = Double.parseDouble(s_cemento_paso12_4);
        String s_a_f_paso_12_4 = mostrar_a_f_paso12_4.getText().toString();
        double d_a_f_paso_12_4 = Double.parseDouble(s_a_f_paso_12_4);

        double a_f_paso_13 = d_a_f_paso_12_4 / d_cemento_paso12_4;
        mostrar_a_f_paso13.setText(String.format("%.2f", a_f_paso_13));

        String s_a_g_paso12_4 = mostrar_a_g_paso12_4.getText().toString();
        double d_a_g_paso12_4 = Double.parseDouble(s_a_g_paso12_4);
        double d_a_g_paso13 = d_a_g_paso12_4 / d_cemento_paso12_4;
        mostrar_a_g_paso13.setText(String.format("%.2f", d_a_g_paso13));

        String f_c_paso7 = mostrar_factor_cemento_v.getText().toString();
        double d_f_c_paso7 = Double.parseDouble(f_c_paso7);
        double bolsas_paso7 = d_f_c_paso7 / 42.5;

        String s_agua_paso12_4 = mostrar_agua_paso12_4.getText().toString();
        double d_agua_paso12_4 = Double.parseDouble(s_agua_paso12_4);
        double agua_paso13 = d_agua_paso12_4 / bolsas_paso7;
        int redondeo_agua_paso13 = (int) Math.round(agua_paso13);
        //mostrar_agua_paso13.setText(String.format("%.2f",agua_paso13));
        mostrar_agua_paso13.setText("" + redondeo_agua_paso13);

        mostrar_aditivo_paso13.setText(String.format("%.3f", aditivo_paso11));


        //------------------paso14-------------------//

        double cemento_paso14 = cemento_paso13 * 42.5;
        mostrar_cemento_paso14.setText(String.format("%.2f", cemento_paso14));

        int redondeo_agua_paso14 = (int) Math.round(agua_paso13);
        //mostrar_agua_paso14.setText(String.format("%.2f",agua_paso13));
        mostrar_agua_paso14.setText("" + redondeo_agua_paso14);

        String s_a_g_paso13 = mostrar_a_g_paso13.getText().toString();
        double d_a_g_paso13_paso14 = Double.parseDouble(s_a_g_paso13);
        double a_g_paso14 = d_a_g_paso13_paso14 * 42.5;
        int redondeo_a_g_paso14 = (int) Math.round(a_g_paso14);
        //mostrar_a_g_paso14.setText(String.format("%.2f",a_g_paso14));
        mostrar_a_g_paso14.setText("" + redondeo_a_g_paso14);

        String s_a_f_paso13 = mostrar_a_f_paso13.getText().toString();
        double d_a_f_paso13_paso14 = Double.parseDouble(s_a_f_paso13);
        double a_f_paso14 = d_a_f_paso13_paso14 * 42.5;
        int redondeo_a_f_paso14 = (int) Math.round(a_f_paso14);
        //   mostrar_a_f_paso14.setText(String.format("%.2f",a_f_paso14));
        mostrar_a_f_paso14.setText("" + redondeo_a_f_paso14);


        int redondeo_aditivo_paso14 = (int) Math.round(aditivo_paso11);
        //mostrar_aditivo_paso_12_4.setText(String.format("%.2f", aditivo_paso11));
        mostrar_aditivo_paso14.setText("" + redondeo_aditivo_paso14);

        //----------------paso 15-----------------------//

        mostrar_mezcla_necesaria_paso15.setText(String.format("%.2f", mezcla_necesaria));

        double cemento_paso15 = mezcla_necesaria * 1;
        mostrar_cemento_paso15.setText(String.format("%.2f", cemento_paso15));

        String s_agua_paso15 = mostrar_agua_paso13.getText().toString();
        double d_agua_agua_paso15 = Double.parseDouble(s_agua_paso15);
        double agua_paso15 = d_agua_agua_paso15 * mezcla_necesaria;
        mostrar_agua_paso15.setText(String.format("%.2f", agua_paso15));

        String s_a_g_paso15 = mostrar_a_g_paso13.getText().toString();
        double d_a_g_paso15 = Double.parseDouble(s_a_g_paso15);
        double a_g_paso15 = d_a_g_paso15 * mezcla_necesaria;
        mostrar_a_g_paso15.setText(String.format("%.2f", a_g_paso15));

        String s_a_f_paso15 = mostrar_a_f_paso13.getText().toString();
        double d_a_f_paso15 = Double.parseDouble(s_a_f_paso15);
        double a_f_paso15 = d_a_f_paso15 * mezcla_necesaria;
        mostrar_a_f_paso15.setText(String.format("%.2f", a_f_paso15));

        String s_aire_paso15 = mostrar_aire_paso12_4.getText().toString();
        double d_aire_paso15 = Double.parseDouble(s_aire_paso15);
        mostrar_aire_paso15.setText(String.format("%.2f", d_aire_paso15));

        mostrar_aditivo_paso15.setText(String.format("%.3f", aditivo_paso11));

    }

    private void showForgotDialog(Context c, String informacion,String Solicitante,
                                  String obra, String ubicacion) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Forgot Password")
                .setMessage("Enter your mobile number?")
                .setView(taskEditText)
                .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String informacion = String.valueOf(taskEditText.getText());
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }
        public void createPDF(){



        btngenerar.setOnClickListener(new View.OnClickListener() {

            Intent intent = getIntent();
            double valor_resis_dis = intent.getDoubleExtra("resis diseño", 0);
            double valor_des_est = intent.getDoubleExtra("desviacion estandar", 0);
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                PdfDocument myPdfDocument = new PdfDocument();
                Paint TituloPrincipal = new Paint();
                Paint Titulos = new Paint();
                Paint items = new Paint();

                PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(500, 800, 1).create();

                PdfDocument.Page myPage1 =myPdfDocument.startPage(myPageInfo1);
                Canvas canvas = myPage1.getCanvas();


                TituloPrincipal.setTextSize(15);
                //TituloPrincipal.setTextAlign(Paint.Align.CENTER);

                Titulos.setTextSize(10);

                items.setTextSize(8);

                canvas.drawText("MÉTODO DEDISEÑO DE MEZCLA COMITÉ ACI 211 Y RNE",55,40 ,TituloPrincipal);
                canvas.drawText("Información",50,60, Titulos);

                canvas.drawText("Soliccitante:",60, 75,items);
                canvas.drawText(mostrar_resistencia_promedio_requerida_especificada.getText().toString(),200,75,items);

                canvas.drawText("Obra:",60, 90,items);
                canvas.drawText( mostrar_fact_modifi.getText().toString(),200,90,items );

                canvas.drawText("Ubicación:",60, 105,items);
                canvas.drawText(mostrar_desviacion_estandar.getText().toString(),200,105,items);

                canvas.drawText("Diseño de Mezcla",100, 120,items);
                //double resistencia_de_diseño = valor_resis_dis;
                String resistencia_de_diseño_string = String.valueOf(valor_resis_dis);
                canvas.drawText( resistencia_de_diseño_string,230,120,items);


                canvas.drawText("Requerimientos",50, 135,Titulos);

                canvas.drawText("Desviación estándar",60, 150,items);
                //double desviacion_standar = valor_des_est;
                String desviacion_standar = String.valueOf(valor_des_est);
                canvas.drawText(desviacion_standar,200,150,items);

                canvas.drawText("Tipo de diseño",60,165,items);
                String aire = intent.getStringExtra("selec_aire");
                canvas.drawText(aire,200,165,items);

                canvas.drawText("Asentamiento",60,180,items);
                String paso_valor_asentamiento = intent.getStringExtra("asentamiento");
                canvas.drawText(paso_valor_asentamiento,200,180,items);

                canvas.drawText("Tamaño maximo del agregado",60,195,items);
                String TMN = intent.getStringExtra("TMN");
                canvas.drawText(TMN,200,195,items);

                canvas.drawText("Exposición",60,210,items);
                String tipo_expo = intent.getStringExtra("tipo_expo");
                canvas.drawText(tipo_expo,200,210,items);

                canvas.drawText("CEMENTO",100,225,items);
                canvas.drawText("Tipo",60,240,items);
                String tipo_de_cemento = intent.getStringExtra("tipo_de_cemento");
                canvas.drawText(tipo_de_cemento,200,240,items);

                canvas.drawText("Marca",60,255,items);
                String marca_de_cemento = intent.getStringExtra("marca_de_cemento");
                canvas.drawText(marca_de_cemento,200,255,items);

                canvas.drawText("ADITIVO",100,270,items);
                canvas.drawText("Tipo",60,285,items);
                String tipo_de_aditivo = intent.getStringExtra("tipo_de_aditivo");
                canvas.drawText(tipo_de_aditivo,200,285,items);

                canvas.drawText("Marca",60,300,items);
                String marca_de_aditivo = intent.getStringExtra("marca_de_aditivo");
                canvas.drawText(marca_de_aditivo,200,300,items);

                canvas.drawText("AGUA",100,315,items);
                String tipo_de_agua = intent.getStringExtra("tipo_de_agua");
                canvas.drawText(tipo_de_agua,95,330,items);

                canvas.drawText("Parámetros Físico",50,345,Titulos);

                canvas.drawText("Descripción",60,360,items);
                canvas.drawText("Unidad",185,360,items);
                canvas.drawText("A. Fino",265,360,items);
                canvas.drawText("A. Grueso",365,360,items);

                canvas.drawText("Peso Específico",60,375,items);
                canvas.drawText("Kg/m3",180,375,items);
                double p_e_a_f = intent.getDoubleExtra("p_e_a_f", 0);
                String s_p_e_a_f = String.valueOf(p_e_a_f);
                canvas.drawText(s_p_e_a_f,260,375,items);

                double p_e_a_g = intent.getDoubleExtra("d_peso_e_a_g", 0);
                String s_p_e_a_g = String.valueOf(p_e_a_g);
                canvas.drawText(s_p_e_a_g,360,375,items);

                canvas.drawText("Peso Unitario Suelto",60,390,items);
                canvas.drawText("Kg/m3",180,390,items);
                String p_u_s_a_f = intent.getStringExtra("p_u_s_a_f");
                canvas.drawText(p_u_s_a_f,260,390,items);

                String p_u_s_a_g = intent.getStringExtra("p_u_s_a_g");
                canvas.drawText(p_u_s_a_g,360,390,items);

                canvas.drawText("Peso Unitario Compactado",60,405,items);
                canvas.drawText("Kg/m3",180,405,items);
                String peso_unit_com_agre_fino = intent.getStringExtra("p_u_c_a_f");
                canvas.drawText(peso_unit_com_agre_fino,260,405,items);

                String peso_unit_com_agre_grueso = intent.getStringExtra("peso_sc_agre_grueso");
                canvas.drawText(peso_unit_com_agre_grueso,360,405,items);

                canvas.drawText("Absorción",60,420,items);
                canvas.drawText("A%",180,420,items);
                double ab_a_f = intent.getDoubleExtra("ab_a_f", 0);
                String s_ab_a_f = String.valueOf(ab_a_f);
                canvas.drawText(s_ab_a_f,260,420,items);

                double ab_a_g = intent.getDoubleExtra("ab_a_g", 0);
                String s_ab_a_g = String.valueOf(ab_a_g);
                canvas.drawText(s_ab_a_g,360,420,items);

                canvas.drawText("Humedad Natural",60,435,items);
                canvas.drawText("H%",180,435,items);
                double h_a_f = intent.getDoubleExtra("h_a_f", 0);
                String s_h_a_f = String.valueOf(h_a_f);
                canvas.drawText(s_h_a_f,260,435,items);

                double h_a_g = intent.getDoubleExtra("h_a_g", 0);
                String s_h_a_g = String.valueOf(h_a_g);
                canvas.drawText(s_h_a_g,360,435,items);

                canvas.drawText("Módulo de Fineza",60,450,items);
                canvas.drawText("H%",180,450,items);
                double modulo_ag_grueso = intent.getDoubleExtra("modulo_ag_grueso", 0);
                String s_modulo_ag_fino_ = String.valueOf(modulo_ag_grueso);
                canvas.drawText(s_modulo_ag_fino_,260,450,items);

                String m_d_f_a_g = intent.getStringExtra("m_d_f_a_g");
                canvas.drawText(m_d_f_a_g,360,450,items);

                canvas.drawText("Datos Obtenidos",50,470, Titulos);

                canvas.drawText("Resistencia promedio requerida",60,485,items);
                canvas.drawText(mostrar_resistencia_promedio_requerida.getText().toString(),210,485,items);

                canvas.drawText("Contenido de agua",60,500,items);
                canvas.drawText(mostrar_volumen_unitario_de_agua.getText().toString(),210,500,items);

                canvas.drawText("Contenido de aire",60,515,items);
                canvas.drawText(mostrar_aire_atrapado.getText().toString(),210,515,items);

                canvas.drawText("Relación a/c",60,530,items);
                canvas.drawText(mostrar_ac_de_diseño.getText().toString(),210,530,items);

                canvas.drawText("Corrección de agua",60,545,items);
                canvas.drawText(mostrar_correccion_de_agua.getText().toString(),210,545,items);


                canvas.drawText("Diseño en Proporción de Peso",50,565,Titulos);

                canvas.drawText(view_13_1.getText().toString(),60,580,items);
                canvas.drawText(mostrar_cemento_paso13.getText().toString(),70,595,items);
                canvas.drawText(view_13_2.getText().toString(),140,580,items);
                canvas.drawText(mostrar_a_f_paso13.getText().toString(),160,595,items);
                canvas.drawText(view_13_3.getText().toString(),220,580,items);
                canvas.drawText(mostrar_a_g_paso13 .getText().toString(),250,595,items);
                canvas.drawText(view_13_4.getText().toString(),320,580,items);
                canvas.drawText(mostrar_agua_paso13.getText().toString(),327,595,items);
                canvas.drawText(view_13_5.getText().toString(),380,580,items);
                canvas.drawText(mostrar_aditivo_paso13.getText().toString(),384,595,items);

                canvas.drawText("Diseño en Peso por Tanda de una Bolsa",50,615,Titulos);

                canvas.drawText(view_14_1.getText().toString(),60,630,items);
                canvas.drawText(mostrar_cemento_paso14.getText().toString(),200,630,items);
                canvas.drawText(view_14_2.getText().toString(),60,645,items);
                canvas.drawText(mostrar_a_f_paso14.getText().toString(),200,645,items);
                canvas.drawText(view_14_3.getText().toString(),60,660,items);
                canvas.drawText(mostrar_a_g_paso14.getText().toString(),200,660,items);
                canvas.drawText(view_14_4.getText().toString(),60,675,items);
                canvas.drawText(mostrar_agua_paso14.getText().toString(),200,675,items);
                canvas.drawText(view_14_5.getText().toString(),60,690,items);
                canvas.drawText(mostrar_aditivo_paso14.getText().toString(),200,690,items);


                myPdfDocument.finishPage(myPage1);

                PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(500, 800, 1).create();

                PdfDocument.Page myPage2 =myPdfDocument.startPage(myPageInfo2);
                Canvas canvas2 = myPage2.getCanvas();

                canvas2.drawText("Dosificación",60,50,Titulos);
                canvas2.drawText(view_15_1.getText().toString(),50,65,items);
                canvas2.drawText(mostrar_mezcla_necesaria_paso15.getText().toString(),200,65,items);
                canvas2.drawText(view_15_2.getText().toString(),50,80,items);
                canvas2.drawText(mostrar_cemento_paso15.getText().toString(),200,80,items);
                canvas2.drawText(view_15_3.getText().toString(),50,95,items);
                canvas2.drawText(mostrar_a_f_paso15.getText().toString(),200,95,items);
                canvas2.drawText(view_15_4.getText().toString(),50,110,items);
                canvas2.drawText(mostrar_a_g_paso15.getText().toString(),200,110,items);
                canvas2.drawText(view_15_5.getText().toString(),50,125,items);
                canvas2.drawText(mostrar_agua_paso15.getText().toString(),200,125,items);
                canvas2.drawText(view_15_6.getText().toString(),50,140,items);
                canvas2.drawText(mostrar_aire_paso15.getText().toString(),200,140,items);
                canvas2.drawText(view_15_7.getText().toString(),50,155,items);
                canvas2.drawText(mostrar_aditivo_paso15.getText().toString(),200,155,items);

                canvas2.drawText("NOTA",60,180,Titulos);
                canvas2.drawText("Éste diseño de mezcla está desarrollado por el comité - ACI, se utilizó" +
                        " el reglamento nacional",50,195,items);
                canvas2.drawText("de edificaciones (E - 060), la norma ACI 211 " +
                        "318, ASTM C33 y la norma técnica peruana.",50,205,items);

                myPdfDocument.finishPage(myPage2);

                File file = new File(Environment.getExternalStorageDirectory(),"Diseño_de_mezcla.pdf");
                try{
                    myPdfDocument.writeTo(new FileOutputStream(file));
                }catch (IOException e){
                    e.printStackTrace();
                }
                myPdfDocument.close();
            }
        });

        }

}