package dev.patika.ecommerce.core.utils;

import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultWithData;
import dev.patika.ecommerce.dto.responses.CursorResponse;
import dev.patika.ecommerce.dto.responses.category.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class ResultHelper {

    public static <T> ResultWithData<T> created(T data){
        return new ResultWithData<>(true, Msg.CREATED, "201", data);
    }

    public static <T> ResultWithData<T> validateError(T data){
        return new ResultWithData<>(false, Msg.VALIDATE_ERROR, "400", data);
    }

    public static <T> ResultWithData<T> ok(T data){
        return new ResultWithData<>(true, Msg.OK, "200", data);
    }

    public static Result successfulOperation(){
        return new Result(true, Msg.OK, "200");
    }

    public static Result notFoundError(String message){
        return new Result(false, message, "404");
    }

    public static <T> ResultWithData<CursorResponse<T>> cursor(Page<T> pageCursor){
        CursorResponse<T> cursorResponse = new CursorResponse<>();
        cursorResponse.setItems(pageCursor.getContent());
        cursorResponse.setPageNumber(pageCursor.getNumber());
        cursorResponse.setPageSize(pageCursor.getSize());
        cursorResponse.setTotalElement(pageCursor.getTotalElements());
        return ResultHelper.ok(cursorResponse);
    }
}
