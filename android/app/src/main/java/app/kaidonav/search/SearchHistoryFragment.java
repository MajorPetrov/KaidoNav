package app.kaidonav.search;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.kaidonav.R;
import app.kaidonav.base.BaseMwmRecyclerFragment;
import app.kaidonav.location.LocationHelper;
import app.kaidonav.routing.RoutingController;
import app.kaidonav.widget.PlaceholderView;
import app.kaidonav.widget.SearchToolbarController;
import app.kaidonav.util.UiUtils;

public class SearchHistoryFragment extends BaseMwmRecyclerFragment<SearchHistoryAdapter>
{
  private PlaceholderView mPlaceHolder;

  private void updatePlaceholder()
  {
    UiUtils.showIf(getAdapter().getItemCount() == 0, mPlaceHolder);
  }

  @NonNull
  @Override
  protected SearchHistoryAdapter createAdapter()
  {
    final SearchToolbarController controller = ((SearchFragment) requireParentFragment()).requireController();
    final boolean showMyPosition = (RoutingController.get().isWaitingPoiPick() &&
        LocationHelper.from(requireContext()).getMyPosition() != null);
    return new SearchHistoryAdapter(controller, showMyPosition);
  }

  @Override
  protected @LayoutRes int getLayoutRes()
  {
    return R.layout.fragment_search_base;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
  {
    super.onViewCreated(view, savedInstanceState);
    getRecyclerView().setLayoutManager(new LinearLayoutManager(view.getContext()));
    mPlaceHolder = view.findViewById(R.id.placeholder);
    mPlaceHolder.setContent(R.string.search_history_title, R.string.search_history_text);

    getAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver()
    {
      @Override
      public void onChanged()
      {
        updatePlaceholder();
      }
    });
    updatePlaceholder();

    ((SearchFragment) getParentFragment()).setRecyclerScrollListener(getRecyclerView());
  }
}
