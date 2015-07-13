package de.derandroidpro.seekbar_tutorial;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	

	public SeekBar sb1;
	public TextView tv1;
	
	int sbvalue;
	int sbmax = 150;
	int sbstart = 45;
	
	public AudioManager am;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		
		sbmax = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		sbstart = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		
		
		
		sb1 = (SeekBar) findViewById(R.id.seekBar1);
		tv1 = (TextView) findViewById(R.id.textView1);
		
		sb1.setMax(sbmax);
		sb1.setProgress(sbstart);
		tv1.setText(Integer.toString(sbstart));
		sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
				sbvalue = sb1.getProgress();
				tv1.setText(Integer.toString(sbvalue));
				
				am.setStreamVolume(AudioManager.STREAM_MUSIC, sbvalue, am.FLAG_SHOW_UI);
				
				
			}
		});
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if(keyCode == KeyEvent.KEYCODE_VOLUME_UP ||keyCode == KeyEvent.KEYCODE_VOLUME_DOWN ) {
			
			sbvalue = am.getStreamVolume(AudioManager.STREAM_MUSIC);
			sb1.setProgress(sbvalue);
			tv1.setText(Integer.toString(sbvalue));
			
			
		}
		
		
		return super.onKeyDown(keyCode, event);
	}
	
}
