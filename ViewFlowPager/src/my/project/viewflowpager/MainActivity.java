package my.project.viewflowpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends Activity {

	private AutoScrollViewPager viewPager;
	private CirclePageIndicator indicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
		indicator = (CirclePageIndicator) findViewById(R.id.indicator);

		List<Integer> imageIdList = new ArrayList<Integer>();
		imageIdList.add(R.drawable.banner1);
		imageIdList.add(R.drawable.banner2);
		imageIdList.add(R.drawable.banner3);
		imageIdList.add(R.drawable.banner4);
		viewPager.setAdapter(new ImagePagerAdapter(this, imageIdList));
		indicator.setViewPager(viewPager);

		viewPager.setInterval(2000);
		viewPager
				.setSlideBorderMode(AutoScrollViewPager.SLIDE_BORDER_MODE_TO_PARENT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		viewPager.startAutoScroll();
	}

	@Override
	protected void onStop() {
		super.onStop();
		viewPager.stopAutoScroll();
	}

}
