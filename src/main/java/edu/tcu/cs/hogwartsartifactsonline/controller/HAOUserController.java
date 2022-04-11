package edu.tcu.cs.hogwartsartifactsonline.controller;

import edu.tcu.cs.hogwartsartifactsonline.domain.HAOUser;
import edu.tcu.cs.hogwartsartifactsonline.domain.Result;
import edu.tcu.cs.hogwartsartifactsonline.domain.StatusCode;
import edu.tcu.cs.hogwartsartifactsonline.service.HAOUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class HAOUserController {

    private HAOUserService HAOUserService;

    public HAOUserController(HAOUserService HAOUserService) {
        this.HAOUserService = HAOUserService;
    }

    @GetMapping
    public Result findAll() {
        List<HAOUser> all = HAOUserService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find All Success", HAOUserService.findAll());
    }

    @GetMapping("/{userId}")
    public Result findById(@PathVariable String userId) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", HAOUserService.findById(userId));
    }

    @PostMapping
    public Result save(@RequestBody HAOUser newHAOUser) {
        HAOUserService.save(newHAOUser);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{userId}")
    public Result update(@RequestBody HAOUser updated, @PathVariable String userId) {
        HAOUserService.update(userId, updated);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{userId}")
    public Result delete(@PathVariable String userId) {
        HAOUserService.deleteById(userId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
