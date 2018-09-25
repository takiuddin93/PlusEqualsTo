package plusequalsto.com.plusequalstoapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayApi {
    @GET("wp-json/wp/v2/posts/?per_page=100")
    Call<List<AllPost>> getPostInfo();
    /// to make call to dynamic URL
    //  @GET
    //  Call<List<AllPost>> getPostInfo(@Url String url);
}
