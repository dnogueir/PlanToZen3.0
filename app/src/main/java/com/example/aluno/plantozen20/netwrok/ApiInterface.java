package com.example.aluno.plantozen20.netwrok;
import java.util.List;

import com.example.aluno.plantozen20.model.Message;
import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by Aluno on 25/09/2017.
 */

public interface ApiInterface {
    @GET("inbox.json")
    Call<List<Message>> getInbox();
}
