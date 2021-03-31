package tntshk.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
    String success;

    public Response(String success) {
        this.success = success;
    }

    public String toJson() {
        return "{" +
                "success:\"" + success + '\"' +
                '}';
    }
}
