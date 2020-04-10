package ucvt.ru;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton mBtnRed, mBtnBlue;
    SoundPool mSPDon, mSPKa;
    int soundDon, soundKa;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mBtnRed = findViewById(R.id.btnRed);
        mBtnBlue = findViewById(R.id.btnBlue);
        AudioAttributes attributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
        mSPDon = new SoundPool.Builder().setAudioAttributes(attributes).build();
        mSPKa = new SoundPool.Builder().setAudioAttributes(attributes).build();
        soundDon = mSPDon.load(getApplicationContext(), R.raw.don, 1);
        soundKa = mSPKa.load(getApplicationContext(), R.raw.ka, 1);
        mBtnRed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        mBtnRed.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.circle_red_small));
                        mSPDon.play(soundDon, 0.8f, 0.8f, 0, 0, 1.3f);
                        break;
                    case MotionEvent.ACTION_UP:
                        mBtnRed.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.circle_red));
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        mBtnBlue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        mBtnBlue.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.circle_blue_small));
                        mSPKa.play(soundKa, 0.8f, 0.8f, 0, 0, 1.3f);
                        break;
                    case MotionEvent.ACTION_UP:
                        mBtnBlue.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.circle_blue));
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}
