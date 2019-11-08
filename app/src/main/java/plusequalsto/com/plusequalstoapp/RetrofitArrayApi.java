package plusequalsto.com.plusequalstoapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayApi {
    @GET("wp-json/wp/v2/posts/?per_page=100")
//    Call<List<AllPosts>> getAllPostsInfo();
    Call<List<AllPosts>> getAllPostsInfo();
    /// to make call to dynamic URL
    //  @GET
    //  Call<List<AllPosts>> getAllPostsInfo(@Url String url);
}
