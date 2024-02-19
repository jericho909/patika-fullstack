package dev.patika.library.api;

import dev.patika.library.business.abstracts.IAuthorService;
import dev.patika.library.core.config.modelmapper.IModelMapperService;
import dev.patika.library.core.result.ResultWithData;
import dev.patika.library.core.utils.ResultHelper;
import dev.patika.library.dto.requests.author.AuthorSaveRequest;
import dev.patika.library.dto.responses.author.AuthorResponse;
import dev.patika.library.entities.Author;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/authors/")
public class AuthorController {
    private final IAuthorService authorService;
    private final IModelMapperService modelMapper;

    public AuthorController(IAuthorService authorService, IModelMapperService modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest){
        Author authorToBeSaved = this.modelMapper.forRequest().map(authorSaveRequest, Author.class);
        this.authorService.save(authorToBeSaved);
        return ResultHelper.created(this.modelMapper.forResponse().map(authorToBeSaved, AuthorResponse.class));
    }
}
