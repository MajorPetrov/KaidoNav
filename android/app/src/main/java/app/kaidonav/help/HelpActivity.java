package app.kaidonav.help;

import androidx.fragment.app.Fragment;

import app.kaidonav.base.BaseToolbarActivity;

public class HelpActivity extends BaseToolbarActivity
{
  @Override
  protected Class<? extends Fragment> getFragmentClass()
  {
    return HelpFragment.class;
  }
}