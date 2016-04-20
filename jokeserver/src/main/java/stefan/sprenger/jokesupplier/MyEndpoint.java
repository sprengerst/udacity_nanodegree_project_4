
/*
 * Copyright (c) 2016. by Stefan Sprenger
 */

package stefan.sprenger.jokesupplier;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.JokeSupplier;

@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "jokesupplier.sprenger.stefan",
    ownerName = "jokesupplier.sprenger.stefan",
    packagePath=""
  )
)
public class MyEndpoint {
    private JokeSupplier jokeSupplier = new JokeSupplier();

    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        response.setData(jokeSupplier.getJoke());
        return response;
    }

}
