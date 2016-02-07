package ru.bluebyte.atomicupdaterbug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class MainActivity extends AppCompatActivity {

	volatile int once;
	static final AtomicIntegerFieldUpdater<MainActivity> ONCE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(MainActivity.class, "once");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ONCE_UPDATER.compareAndSet(this, 0, 1);
	}
}
