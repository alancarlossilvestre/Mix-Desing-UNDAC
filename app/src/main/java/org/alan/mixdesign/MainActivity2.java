package org.alan.mixdesign;
//-----------------------Dosificacion----------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

   TextView mostrar_fact_modifi , mostrar_desviacion_estandar, mostrar_resistencia_promedio_requerida,valor_asentamiento,
            mostrar_resistencia_promedio_requerida_especificada, mostrar_ressi_prom_mod, mostrar_TMN_agre_gru, mostrar_peso_sec_comp_agre_gr,
            mostrar_volumen_unitario_de_agua, mostrar_aire_atrapado, mostrar_factor_cemento, mostrar_TMN_agre_gru_k, mostrar_cantidad_agregado_grueso,
            mostrar_fcr_agua_cemento_por_resistencia, mostrar_fcr_agua_cemento_por_durabilidad,
            mostrar_ac_de_diseño, mostrar_factor_cemento_v, mostrar_correccion_de_agua,
            mostrar_agua_paso9, mostrar_cemento_paso9, mostrar_aire_paso9, mostrar_v_a_g_paso9, mostrar_suma_paso9, mostrar_estado_paso9, mostrar_aditivo_paso9,
            mostrar_vol_a_f_paso9, mostrar_agua_paso11, mostrar_cemento_paso11, mostrar_aire_paso11, mostrar_v_a_g_paso11, mostrar_v_a_f_paso11, mostrar_aditivo11,
            mostrar_vol_paso10, mostrar_peso_paso10, mostrar_a_f_paso12, mostrar_a_g_paso12,  mostrar_a_f_paso122, mostrar_agua_efectiva,
            mostrar_a_g_paso122, mostrar_a_f_paso123, mostrar_a_g_paso123, mostrar_cemento_paso12_4, mostrar_agua_paso12_4, mostrar_aire_paso12_4,
            mostrar_aditivo_paso_12_4, mostrar_a_f_paso12_4, mostrar_a_g_paso12_4, mostrar_cemento_paso13, mostrar_a_f_paso13, mostrar_a_g_paso13,
            mostrar_agua_paso13, mostrar_aditivo_paso13,  mostrar_cemento_paso14, mostrar_a_f_paso14, mostrar_a_g_paso14,
            mostrar_agua_paso14, mostrar_aditivo_paso14, mostrar_cemento_paso15, mostrar_a_f_paso15, mostrar_a_g_paso15,
            mostrar_agua_paso15, mostrar_aditivo_paso15, mostrar_aire_paso15, mostrar_mezcla_necesaria_paso15, mostrar_bolsas;
    double  valor_resis_dis1,valor_resis_dis2, d_valor_resis_dis1_F,fcr_a_c;
    double valor, aire_atrapado, d_cantidad_agre_grueso, v_f_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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

        double p_e_a_g = intent.getDoubleExtra("d_peso_e_a_g",0);

        double d_p_c = intent.getDoubleExtra("d_p_c",0);
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
        if (aire.equals("Con aire")){
            String s_fcr_a_c =  mostrar_fcr_agua_cemento_por_resistencia.getText().toString();
            double n_fcr_a_c = Double.parseDouble(s_fcr_a_c);
            // Toast.makeText(this, " valor " + fcr_a_c + ac_durabildiad, Toast.LENGTH_LONG).show();
            if(fcr_a_c<ac_durabildiad){
                double seleccion_ac = n_fcr_a_c;
                mostrar_ac_de_diseño.setText(String.format("%.2f", seleccion_ac));
                double a_c = (valor/seleccion_ac);
                String s_a_c = String.valueOf(a_c);
                mostrar_ac_de_diseño.setText(String.format("%.2f", a_c));
                //    Toast.makeText(this, " seleccion  " + a_c, Toast.LENGTH_LONG).show();

            }else if(fcr_a_c>ac_durabildiad) {
                double seleccion_ac = ac_durabildiad;
                mostrar_ac_de_diseño.setText(String.format("%.2f", seleccion_ac));
                double a_c = (valor/seleccion_ac);
                mostrar_ac_de_diseño.setText(String.format("%.2f", a_c));
                //  Toast.makeText(this, " seleccion  " + a_c, Toast.LENGTH_LONG).show();

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
        if(aire.equals("Sin aire")){
            String s_ac_resistencia = mostrar_fcr_agua_cemento_por_resistencia.getText().toString();
            double d_ac_resistencia_sinaire  =   Double.parseDouble(s_ac_resistencia);
            mostrar_factor_cemento_v.setText(String.format("%.2f", fcr_a_c));
            double r_ac_diseño_paso6 = valor/ d_ac_resistencia_sinaire;

            mostrar_factor_cemento_v.setText(String.format("%.2f", r_ac_diseño_paso6));
            mostrar_ac_de_diseño.setText(String.format("%.2f", fcr_a_c));

          }
        String s_paso7 = mostrar_factor_cemento_v.getText().toString();
        Double d_paso7 = Double.parseDouble(s_paso7);


        double r_paso_7 = d_paso7/42.5;
        int redondeo_bolsa_paso7 =(int)Math.round(r_paso_7);

        mostrar_bolsas.setText(""+redondeo_bolsa_paso7);

//------------------------------------------------------------------------------------------------//
//----------------------------K G-----------------------------------------------------------------//
        //agregado grueo------------------------------------------------------------------------//
        if (TMN.equals("3/8''") && modulo_ag_grueso<= 2.40) {
            v_f_c = 0.50;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.50 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));

        }
        if (TMN.equals("3/8''") && modulo_ag_grueso> 2.40 && modulo_ag_grueso < 2.60) {
            v_f_c = 0.50 + ( modulo_ag_grueso- 2.40 ) / (2.60-2.40) * ( 0.48-0.50);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));


            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
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
            v_f_c = 0.48 + ( modulo_ag_grueso- 2.60 ) / (2.80-2.60) * (0.46-0.48);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/8''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.46;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.46 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/8''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            v_f_c = 0.46 + ( modulo_ag_grueso- 2.80 ) / (3.00-2.80) * ( 0.44-0.46);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/8''") && modulo_ag_grueso >= 3.0) {
            v_f_c =0.44;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.44 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));

        }
        if (TMN.equals("1/2''") && modulo_ag_grueso <= 2.40) {
            v_f_c =0.59;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.59 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            v_f_c = 0.59 + ( modulo_ag_grueso- 2.40 ) / (2.60-2.40) * ( 0.57-0.59);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso == 2.60) {
            v_f_c =0.57;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.57 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            v_f_c = 0.57 + ( modulo_ag_grueso- 2.60 ) / (2.80-2.60) * ( 0.55-0.57);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.55;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.55 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            v_f_c = 0.55 + ( modulo_ag_grueso- 2.80 ) / (3.00 - 2.80) * (0.53 - 0.55);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1/2''") && modulo_ag_grueso >= 3.00) {
            v_f_c =0.53;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.53 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("3/4''") && modulo_ag_grueso <= 2.40) {
            v_f_c =0.66;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.66 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {

            v_f_c = 0.66 + ( modulo_ag_grueso- 2.40 ) / (2.60 - 2.40) * (0.64 - 0.66);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));


            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso == 2.60) {
            v_f_c =0.64;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.64 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {

            v_f_c = 0.64 + ( modulo_ag_grueso- 2.60 ) / (2.80 - 2.60) * (0.62 - 0.64);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.62;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.62 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {

            v_f_c = 0.62 + ( modulo_ag_grueso- 2.80 ) / (3.00 - 2.80) * (0.60 - 0.62);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3/4''") && modulo_ag_grueso >= 3.00) {
            v_f_c =0.60;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.60 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("1''") && modulo_ag_grueso <= 2.40) {
            v_f_c =0.71;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.71 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {

            v_f_c = 0.71 + ( modulo_ag_grueso- 2.40 ) / (2.60 - 2.40) * (0.69 - 0.71);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso == 2.60) {
            v_f_c =0.69;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.69 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {

            v_f_c = 0.69 + ( modulo_ag_grueso- 2.60 ) / (2.80 - 2.60) * (0.67- 0.69);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.67;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.67 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            v_f_c = 0.67 + ( modulo_ag_grueso- 2.80 ) / (3.00 - 2.80) * (0.65- 0.67);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1''") && modulo_ag_grueso >= 3.00) {
            v_f_c =0.65;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.65 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }


        if (TMN.equals("1 1/2''") && modulo_ag_grueso <= 2.40) {
            v_f_c =0.76;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.76 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso> 2.40 && modulo_ag_grueso < 2.60) {
            v_f_c = 0.76 + ( modulo_ag_grueso- 2.40 ) / (2.60- 2.40) * (0.74- 0.76);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso == 2.60) {
            v_f_c =0.74;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.74 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.73 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.74 + ( modulo_ag_grueso-2.60 ) / (2.80-2.60) * (0.72- 0.74);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.72;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.72 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.71 + (3.00 - modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.72 + ( modulo_ag_grueso- 2.80 ) / (3.00-2.80) * (0.70-0.72);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.3f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("1 1/2''") && modulo_ag_grueso >= 3.00) {
            v_f_c =0.70;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("2''") && modulo_ag_grueso <= 2.40) {
            v_f_c =0.78;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.78 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            //v_f_c = 0.78 + (2.60 - modulo_ag_grueso) / (modulo_ag_grueso - 2.40) * (modulo_ag_grueso - 2.40);
            v_f_c = 0.78 + ( modulo_ag_grueso- 2.40 ) / ( 2.60-2.40) * (0.76- 0.78);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso == 2.60) {
            v_f_c =0.76;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));;

            d_cantidad_agre_grueso = 0.76 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));

        }
        if (TMN.equals("2''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.76 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.76 + ( modulo_ag_grueso- 2.60 ) / ( 2.80-2.60) * (0.74- 0.76);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(str_cantidad_agreg_grueso);
        }
        if (TMN.equals("2''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.74;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.74 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.74 + (3.00 - modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.74 + ( modulo_ag_grueso- 2.80 ) / ( 3.00-2.80) * (0.72- 0.74);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("2''") && modulo_ag_grueso >= 3.00) {
            v_f_c =0.72;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.72 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("3''") && modulo_ag_grueso <= 2.40) {
            v_f_c =0.82;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.82 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso> 2.40 && modulo_ag_grueso < 2.60) {
            //v_f_c = 0.82 + (2.60 - modulo_ag_grueso) / (modulo_ag_grueso - 2.40) * (modulo_ag_grueso - 2.40);
            v_f_c = 0.82 + ( modulo_ag_grueso- 2.40 ) / ( 2.60-2.40) * (0.80- 0.82);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso == 2.60) {
            v_f_c =0.80;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.80 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.80 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.80 + ( modulo_ag_grueso- 2.60 ) / ( 2.80-2.60) * (0.78- 0.80);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.78;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.78 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.78 + (3.00 -modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.78 + ( modulo_ag_grueso- 2.80 ) / ( 3.00-2.80) * (0.76- 0.78);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("3''") && modulo_ag_grueso >= 3.00) {
            v_f_c =0.76;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.76 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }

        if (TMN.equals("6''") && modulo_ag_grueso <= 2.40) {
            v_f_c =0.87;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.87 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso > 2.40 && modulo_ag_grueso < 2.60) {
            //v_f_c = 0.87 + (2.60 - modulo_ag_grueso) / (modulo_ag_grueso - 2.40) * (modulo_ag_grueso - 2.40);
            v_f_c = 0.87 + ( modulo_ag_grueso- 2.40 ) / ( 2.60-2.40) * (0.85- 0.87);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso == 2.60) {
            v_f_c =0.85;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.85 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso > 2.60 && modulo_ag_grueso < 2.80) {
            //v_f_c = 0.85 + (2.80 - modulo_ag_grueso) / (modulo_ag_grueso - 2.60) * (modulo_ag_grueso - 2.60);
            v_f_c = 0.85 + ( modulo_ag_grueso- 2.60 ) / ( 2.80-2.60) * (0.83- 0.85);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso == 2.80) {
            v_f_c =0.83;
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            d_cantidad_agre_grueso = 0.83 * d_peso_sc_agre_grueso;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso > 2.80 && modulo_ag_grueso < 3.00) {
            //v_f_c = 0.80 + (3.00 - modulo_ag_grueso) / (modulo_ag_grueso - 2.80) * (modulo_ag_grueso - 2.80);
            v_f_c = 0.80 + ( modulo_ag_grueso- 2.80 ) / ( 3.00-2.80) * (0.81- 0.83);
            String s_v_f_c = String.valueOf(v_f_c);
            mostrar_factor_cemento.setText(String.format("%.2f", v_f_c));

            String s_vfc = mostrar_factor_cemento.getText().toString();
            Double d_vfc= Double.parseDouble(s_vfc);

            d_cantidad_agre_grueso = d_vfc * d_peso_sc_agre_grueso;;
            String str_cantidad_agreg_grueso = String.valueOf(d_cantidad_agre_grueso);
            mostrar_cantidad_agregado_grueso.setText(String.format("%.2f", d_cantidad_agre_grueso));
        }
        if (TMN.equals("6''") && modulo_ag_grueso >= 3.00) {
            v_f_c =0.81;
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
        double cemento =  d_cemento_paso7/d_p_c;
        mostrar_cemento_paso9.setText(String.format("%.3f", cemento));
        double agua_paso_9 = valor / 1000;
        mostrar_agua_paso9.setText(String.format("%.3f", agua_paso_9));
        double aire_paso9 = aire_atrapado/100;

        String s_a_g_paso8 = mostrar_cantidad_agregado_grueso.getText().toString();
        double d_a_g_paso8 = Double.parseDouble(s_a_g_paso8);

        mostrar_aire_paso9.setText(String.format("%.3f", aire_paso9));
        double v_a_g_paso9 = d_a_g_paso8/p_e_a_g;
        mostrar_v_a_g_paso9.setText(String.format("%.3f", v_a_g_paso9));

       // Toast.makeText(this, " pasa  " +  d_a_g_paso8 + p_e_a_g, Toast.LENGTH_LONG).show();
        String s_f_c = mostrar_factor_cemento_v.getText().toString();
        double d_f_c = Double.parseDouble(s_f_c);
        double aditivo = (d_f_c*aditivoxbls)/1000000;
        mostrar_aditivo_paso9.setText(String.format("%.3f", aditivo));
        double suma = cemento + agua_paso_9 + aire_paso9 + v_a_g_paso9 + aditivo;

        mostrar_suma_paso9.setText(String.format("%.3f", suma));

        if(suma<1.0){
            String no_aceptado = "<font color='#EE0000'>sumatoria insuficiente</font>";
            mostrar_estado_paso9.setText(Html.fromHtml(no_aceptado ));

        }else if(suma>=1.0){
            String aceptado = "<font color='#FFFFFF'>sumatoria suficiente</font>";
            mostrar_estado_paso9.setText(Html.fromHtml(aceptado ));
        }


        //------------paso 10------------------------//
        double v_a_F = 1.0 - suma;
        mostrar_vol_paso10.setText(String.format("%.3f", v_a_F));
        String s_v_a_f = mostrar_vol_paso10.getText().toString();
        double d_v_a_f = Double.parseDouble(s_v_a_f);
        double peso_paso10 = d_v_a_f*p_e_a_f;
        mostrar_peso_paso10.setText(String.format("%.2f", peso_paso10));

        //------------paso11--------------------------//
        String c_11= mostrar_factor_cemento_v.getText().toString();
        //double cemento_11 =  valor /0.557;
        double agua_paso_11 = valor ;
        double aire_paso11 = aire_atrapado;
        double v_a_g_paso11 = (d_peso_sc_agre_grueso*v_f_c);
        String adtivo_paso9 = mostrar_aditivo_paso9.getText().toString();
        double d_aditivo_paso9 = Double.parseDouble(adtivo_paso9);
        double aditivo_paso11 = d_aditivo_paso9*p_e_aditivo;

        mostrar_cemento_paso11.setText(c_11);
        mostrar_agua_paso11.setText(String.format("%.2f", agua_paso_11));
        mostrar_aire_paso11.setText(String.format("%.2f", aire_paso11));
        mostrar_v_a_g_paso11.setText(String.format("%.2f", v_a_g_paso11));
        mostrar_v_a_f_paso11.setText(String.format("%.2f", peso_paso10));
        mostrar_aditivo11.setText(String.format("%.2f", aditivo_paso11));

        //------------paso12--------------------------------//
        double a_f_paso12 = peso_paso10*(1+(h_a_f/100));
        mostrar_a_f_paso12.setText(String.format("%.2f", a_f_paso12));

        String s_a_g_paso11 =  mostrar_v_a_g_paso11.getText().toString();
        double d_a_g_paso11 = Double.parseDouble(s_a_g_paso11);
        double a_g_paso12 = d_a_g_paso11*(1+(h_a_g/100));
        mostrar_a_g_paso12.setText(String.format("%.2f", a_g_paso12));

        //------------paso12.2--------------------------------//

        double a_f_paso122= h_a_f-ab_a_f;
        mostrar_a_f_paso122.setText(String.format("%.2f", a_f_paso122));

        double a_g_paso12_2 = h_a_g - ab_a_g;
        mostrar_a_g_paso122.setText(String.format("%.2f", a_g_paso12_2));

        //------------paso12.3--------------------------------//
        String s_peso_paso10 =  mostrar_v_a_f_paso11.getText().toString();
        double  n_peso_paso10 = Double.parseDouble(s_peso_paso10);

        String s_a_f_paso122 = mostrar_a_f_paso122.getText().toString();
        double n_a_f_paso122 = Double.parseDouble(s_a_f_paso122);

        double a_f_paso12_3=  (n_peso_paso10*n_a_f_paso122)/100;
        mostrar_a_f_paso123.setText(String.format("%.2f", a_f_paso12_3));

        String s_v_a_g_paso11 =   mostrar_v_a_g_paso11.getText().toString();
        double  n_v_a_g_paso11 = Double.parseDouble(s_v_a_g_paso11);

        String s_a_g_paso122 =mostrar_a_g_paso122.getText().toString();
        double n_a_g_paso122 = Double.parseDouble(s_a_g_paso122);

        double a_g_paso12_3 =  (n_a_g_paso122* n_v_a_g_paso11)/100;
        mostrar_a_g_paso123.setText(String.format("%.2f", a_g_paso12_3));
        //-------mostarr correccion de agua---------//

        String s_a_f_correc_agua = mostrar_a_f_paso123.getText().toString();
        double d_a_f_correc_agua = Double.parseDouble(s_a_f_correc_agua);

        String s_a_g_correc_agua = mostrar_a_g_paso123.getText().toString();
        double d_a_g_correc_agua = Double.parseDouble(s_a_g_correc_agua);


        double correccion_de_agua = d_a_f_correc_agua + d_a_g_correc_agua;
        mostrar_correccion_de_agua.setText(String.format("%.2f", correccion_de_agua));


        //----------mostarar agua efectiva ----//
        String s_correccion_agua_= mostrar_correccion_de_agua.getText().toString();
        double d_correccion_agua = Double.parseDouble(s_correccion_agua_);

        if (d_correccion_agua>0.0){
            double a_f= valor - d_correccion_agua;
            mostrar_agua_efectiva.setText(String.format("%.2f", a_f));
        } else if(d_correccion_agua<0.0){
            double a_f = valor - d_correccion_agua  ;
            mostrar_agua_efectiva.setText(String.format("%.2f", a_f));
        }

        //Toast.makeText(this, " v_f_c  "+ n_peso_paso10 +"  "+ n_a_f_paso122 , Toast.LENGTH_LONG).show();

        //valores corregidos por humedad

        String cemento_correc_huem =mostrar_factor_cemento_v.getText().toString();
        double d_cemento_correc_huem = Double.parseDouble(cemento_correc_huem);
        mostrar_cemento_paso12_4.setText(String.format("%.2f", d_cemento_correc_huem));

        String agua_efec = mostrar_agua_efectiva.getText().toString();
        double d_agua_efec = Double.parseDouble(agua_efec);
        int redondeo_agua_paso12_4 = (int)Math.round(d_agua_efec);
//        mostrar_agua_paso12_4.setText(String.format("%.2f", d_agua_efec));
        mostrar_agua_paso12_4.setText(""+redondeo_agua_paso12_4);

        //String aire_12_4 = mostrar_aire_atrapado.getText().toString();
        //double d_aire_12_4 = Double.parseDouble(aire_12_4);
        int redondeo_aire_paso12_4 = (int)Math.round(aire_atrapado);
        //mostrar_aire_paso12_4.setText(String.format("%.2f",aire_atrapado));
        mostrar_aire_paso12_4.setText(""+redondeo_aire_paso12_4);

        String s_a_g_12_4 = mostrar_a_g_paso12.getText().toString();
        double d_a_g_12_4 = Double.parseDouble(s_a_g_12_4);
        int redondeo_a_g_paso12_4 = (int)Math.round(d_a_g_12_4);
        //mostrar_a_g_paso12_4.setText(String.format("%.2f",d_a_g_12_4));
        mostrar_a_g_paso12_4.setText(""+redondeo_a_g_paso12_4);

        String s_a_f_12_4 = mostrar_a_f_paso12.getText().toString();
        double d_a_f_12_4 = Double.parseDouble(s_a_f_12_4);
        int redondeo_a_f_paso12_4 = (int)Math.round(d_a_f_12_4);
        //mostrar_a_f_paso12_4.setText(String.format("%.2f",d_a_f_12_4));
        mostrar_a_f_paso12_4.setText(""+redondeo_a_f_paso12_4);

        int redondeo_aditivo_paso12_4 = (int)Math.round(aditivo_paso11);
        //mostrar_aditivo_paso_12_4.setText(String.format("%.2f", aditivo_paso11));
        mostrar_aditivo_paso_12_4.setText(""+redondeo_aditivo_paso12_4);

        //------------------------------paso13--------------------------//
        double cemento_paso13 = 1.00;
        mostrar_cemento_paso13.setText(String.format("%.2f", cemento_paso13));

        String s_cemento_paso12_4 = mostrar_cemento_paso12_4.getText().toString();
        double d_cemento_paso12_4 = Double.parseDouble(s_cemento_paso12_4);
        String s_a_f_paso_12_4 = mostrar_a_f_paso12_4.getText().toString();
        double d_a_f_paso_12_4 = Double.parseDouble(s_a_f_paso_12_4);

        double a_f_paso_13 = d_a_f_paso_12_4/d_cemento_paso12_4;
        mostrar_a_f_paso13.setText(String.format("%.2f",a_f_paso_13));

        String s_a_g_paso12_4 = mostrar_a_g_paso12_4.getText().toString();
        double  d_a_g_paso12_4 = Double.parseDouble(s_a_g_paso12_4);
        double  d_a_g_paso13 = d_a_g_paso12_4/d_cemento_paso12_4;
        mostrar_a_g_paso13.setText(String.format("%.2f",d_a_g_paso13));

        String f_c_paso7 = mostrar_factor_cemento_v.getText().toString();
        double d_f_c_paso7 = Double.parseDouble(f_c_paso7);
        double bolsas_paso7 = d_f_c_paso7/42.5;

        String s_agua_paso12_4 = mostrar_agua_paso12_4.getText().toString();
        double d_agua_paso12_4 = Double.parseDouble(s_agua_paso12_4);
        double agua_paso13 = d_agua_paso12_4/bolsas_paso7;
        int redondeo_agua_paso13= (int) Math.round(agua_paso13);
        //mostrar_agua_paso13.setText(String.format("%.2f",agua_paso13));
        mostrar_agua_paso13.setText(""+redondeo_agua_paso13);

        mostrar_aditivo_paso13.setText(String.format("%.2f", aditivo_paso11));


        //------------------paso14-------------------//

        double cemento_paso14 = cemento_paso13*42.5;
        mostrar_cemento_paso14.setText(String.format("%.2f",cemento_paso14));

        int redondeo_agua_paso14 = (int)Math.round(agua_paso13);
        //mostrar_agua_paso14.setText(String.format("%.2f",agua_paso13));
        mostrar_agua_paso14.setText(""+redondeo_agua_paso14);

        String s_a_g_paso13 = mostrar_a_g_paso13.getText().toString();
        double d_a_g_paso13_paso14 = Double.parseDouble(s_a_g_paso13);
        double a_g_paso14 = d_a_g_paso13_paso14*42.5;
        int redondeo_a_g_paso14 = (int)Math.round(a_g_paso14);
        //mostrar_a_g_paso14.setText(String.format("%.2f",a_g_paso14));
        mostrar_a_g_paso14.setText(""+redondeo_a_g_paso14);

        String s_a_f_paso13 = mostrar_a_f_paso13.getText().toString();
        double d_a_f_paso13_paso14 = Double.parseDouble(s_a_f_paso13);
        double a_f_paso14 = d_a_f_paso13_paso14*42.5;
        int redondeo_a_f_paso14 = (int)Math.round(a_f_paso14);
     //   mostrar_a_f_paso14.setText(String.format("%.2f",a_f_paso14));
        mostrar_a_f_paso14.setText(""+redondeo_a_f_paso14);


        int redondeo_aditivo_paso14 = (int)Math.round(aditivo_paso11);
        //mostrar_aditivo_paso_12_4.setText(String.format("%.2f", aditivo_paso11));
        mostrar_aditivo_paso14.setText(""+redondeo_aditivo_paso14);

        //----------------paso 15-----------------------//

        mostrar_mezcla_necesaria_paso15.setText(String.format("%.2f", mezcla_necesaria));

        double cemento_paso15 = mezcla_necesaria*1;
        mostrar_cemento_paso15.setText(String.format("%.2f", cemento_paso15));

        String s_agua_paso15 = mostrar_agua_paso13.getText().toString();
        double d_agua_agua_paso15 = Double.parseDouble(s_agua_paso15);
        double agua_paso15 = d_agua_agua_paso15*mezcla_necesaria;
        mostrar_agua_paso15.setText(String.format("%.2f", agua_paso15));

        String s_a_g_paso15 = mostrar_a_g_paso13.getText().toString();
        double d_a_g_paso15 = Double.parseDouble(s_a_g_paso15);
        double a_g_paso15 = d_a_g_paso15*mezcla_necesaria;
        mostrar_a_g_paso15.setText(String.format("%.2f", a_g_paso15));

        String s_a_f_paso15 = mostrar_a_f_paso13.getText().toString();
        double d_a_f_paso15 = Double.parseDouble(s_a_f_paso15);
        double a_f_paso15 = d_a_f_paso15*mezcla_necesaria;
        mostrar_a_f_paso15.setText(String.format("%.2f", a_f_paso15));

        String s_aire_paso15 = mostrar_aire_paso12_4.getText().toString();
        double d_aire_paso15 = Double.parseDouble(s_aire_paso15);
        mostrar_aire_paso15.setText(String.format("%.2f", d_aire_paso15));

        mostrar_aditivo_paso15.setText(String.format("%.2f",aditivo_paso11));

}
}