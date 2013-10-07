package com.vsharma.tipcalculator;

import com.zynga.tipcalculator.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class TipCalculatorActivity extends Activity {

	private TextView tvTipAmount;
	private EditText etBillAmount;
	private SeekBar sbTipOptions;
	private double value;
	private TextView tvTotalAmount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		tvTipAmount = (TextView) findViewById(R.id.tvBillAmount);
		etBillAmount = (EditText) findViewById(R.id.etBillAmount);
		sbTipOptions = (SeekBar) findViewById(R.id.sbTipOptions);
		tvTotalAmount = (TextView) findViewById(R.id.tvTotatAmount);
		
		sbTipOptions.setOnSeekBarChangeListener( new OnSeekBarChangeListener()
		{
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				try {
					double billAmount = Double.parseDouble(etBillAmount.getText().toString());
	                value = (billAmount*progress)/100;
	                String result = String.format("%.2f", value);
	                tvTipAmount.setText("$"+result + " ("+progress+"%)");
	                String total = String.format("%.2f", (billAmount+value));
	                tvTotalAmount.setText("$"+total);
				}catch (Exception ex) {
					ex.printStackTrace();
				}
                
            }
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }
            public void onStopTrackingTouch(SeekBar seekBar)
            {
            }
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void onChange(View v) {
	}

}
