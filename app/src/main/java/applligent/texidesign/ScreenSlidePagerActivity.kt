package applligent.texidesign

import android.app.Activity
import android.os.Bundle
import android.support.v4.view.ViewPager


public class ScreenSlidePagerActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide)
        var viewPager: ViewPager = findViewById(R.id.view_pager);
        var adapter: ImageAdapter = ImageAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(adapter.getCount() - 1);

    }
}