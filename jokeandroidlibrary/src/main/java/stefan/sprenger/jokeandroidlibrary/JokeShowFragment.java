package stefan.sprenger.jokeandroidlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeShowFragment extends Fragment {

    public JokeShowFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke_show, container, false);

        TextView jokeView = (TextView) root.findViewById(R.id.joke_view_text_view);

        Bundle arguments = getArguments();

        if (arguments != null) {
            String libraryJoke = arguments.getString(getContext().getString(R.string.joke_id_key));
            jokeView.setText(libraryJoke);
        }

        return root;
    }
}
