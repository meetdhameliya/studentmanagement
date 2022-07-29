package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    ResultRepository resultRepository;


    // Mappings - URL endpoints
    // Get the list of all result
    @GetMapping("/listResults")
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    // Get the result information
    @GetMapping("/result/{id}")
    public Result getResult(@PathVariable Integer id) {
        return resultRepository.findById(id).get();
    }

    // Delete the result
    @DeleteMapping("/result/{id}")
    public List<Result> deleteResult(@PathVariable Integer id) {
        resultRepository.delete(resultRepository.findById(id).get());
        return resultRepository.findAll();
    }

    // Add new result
    @PostMapping("/result")
    public List<Result> addResult(@RequestBody Result result) {
        resultRepository.save(result);
        return resultRepository.findAll();
    }

    // Update the result information
    @PutMapping("/result/{id}")
    public List<Result> updateResult(@RequestBody Result result, @PathVariable Integer id) {
        Result resultObj = resultRepository.findById(id).get();
        resultObj.setId(result.getId());
        resultObj.setMarks(result.getMarks());
        resultRepository.save(resultObj);
        return resultRepository.findAll();
    }

}