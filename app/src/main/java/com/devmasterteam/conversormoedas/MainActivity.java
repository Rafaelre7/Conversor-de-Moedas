package com.devmasterteam.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Fala qual activity_main está apontando

        this.mViewHolder.editValue = (EditText) findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = (TextView) findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = (TextView) findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculator = (Button) findViewById(R.id.button_calculate);
        this.mViewHolder.buttonLimpar = (Button) findViewById(R.id.button_limpar);

        this.mViewHolder.buttonCalculator.setOnClickListener(this);
        this.mViewHolder.buttonLimpar.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button_calculate:
                Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
                this.mViewHolder.textDolar.setText(String.format("%.2f",value * 3.69));
                this.mViewHolder.textEuro.setText(String.format("%.2f",value * 4.24));
                break;
            case R.id.button_limpar:
                this.mViewHolder.editValue.setText("");
                this.mViewHolder.textDolar.setText("");
                this.mViewHolder.textEuro.setText("");
                break;
             default:
                 break;
        }

    }
    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }


    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculator;
        Button buttonLimpar;
    }
}
