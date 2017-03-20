package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

  /**Resource ID for the background color for this list of words */
  private int mColorResourceId;

  public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.
    super(context, 0, words);
    mColorResourceId = colorResourceId;
  }

  /**
   *
   * @param position The AdapterView position that is requesting a view
   * @param convertView The recycled view to populate. (search online for "android view recycling" to learn more.)
   * @param parent the parent ViewGroup that is used for inflation.
   * @return the View for the position in the AdapterView.
   */
  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    // Check if an existing view is being reused, otherwise inflate the view
    View listItemView = convertView;
    if (listItemView == null) {
      listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }

    // Get the {@link Word} object located at this position in the list
    Word currentWord = getItem(position);

    // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
    TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
    // Get the Miwok translation from the currentWord object and set this text on the Miwok TextView.
    miwokTextView.setText(currentWord.getMiwokTranslation());

    // Find the TextView in the list_item.xml layout with the ID default_text_view.
    TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
    // Get the default translation from the currentWord object and set this text on the default TextView.
    defaultTextView.setText(currentWord.getDefaultTranslation());

    ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
    if (currentWord.hasImage()) {
      // Set the ImageView to the image resource specified in the current Word
      imageView.setImageResource(currentWord.getImageResourceId());

      // Make sure the imageView is visible
      imageView.setVisibility(View.VISIBLE);
    } else {
      // Hide the imageView
      imageView.setVisibility(View.GONE);
    }

    // Set the theme color for the list item
    View textContainer = listItemView.findViewById(R.id.text_container);
    // Find the color that the resource ID maps to
    int color = ContextCompat.getColor(getContext(), mColorResourceId);
    // Set the background color of the text container view
    textContainer.setBackgroundColor(color);

    // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView.
    return listItemView;
  }
}
