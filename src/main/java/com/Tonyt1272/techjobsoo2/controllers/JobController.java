package com.Tonyt1272.techjobsoo2.controllers;

import com.Tonyt1272.techjobsoo2.models.*;
import com.Tonyt1272.techjobsoo2.models.data.JobData;
import com.Tonyt1272.techjobsoo2.models.forms.JobForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    //public String index(Model model, @PathVariable("id") int id) {
    public String index(Model model, @RequestParam int id) {

        model.addAttribute("job", jobData.findById(id));
        // TODO #1 - get the Job with the given ID and pass it into the view

        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        if(errors.hasErrors()) {
            model.addAttribute("jobForm", jobForm);
            return "new-job";}
        String name = jobForm.getName();
        Employer employer = jobData.getEmployers().findById(jobForm.getEmployerId());
        Location location = jobData.getLocations().findById(jobForm.getLocation());
        PositionType positionType = jobData.getPositionTypes().findById(jobForm.getPositionType());
        CoreCompetency coreCompetency = jobData.getCoreCompetencies().findById(jobForm.getCoreCompetency());

            Job newJob = new Job(name,employer,location,positionType,coreCompetency);
//            newJob.setName(name);
//            newJob.setEmployer(employer);
//            newJob.setLocation(location);
//            newJob.setPositionType(positionType);
//            newJob.setCoreCompetency(coreCompetency);
            int id=newJob.getId();
            jobData.add(newJob);

        // TODO #6 - Validate the JobForm model, and if valid, create a

        String newJobPath = "/job/?id="+id;
        return "redirect:"+ newJobPath;
        //return "";

    }
}