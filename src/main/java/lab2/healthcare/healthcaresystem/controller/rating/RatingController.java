package lab2.healthcare.healthcaresystem.controller.rating;

import lab2.healthcare.healthcaresystem.models.Doctor;
import lab2.healthcare.healthcaresystem.models.Patient;
import lab2.healthcare.healthcaresystem.models.Rating;
import lab2.healthcare.healthcaresystem.service.DoctorService;
import lab2.healthcare.healthcaresystem.service.PatientService;
import lab2.healthcare.healthcaresystem.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class RatingController {

    public Doctor doctorSelected;
    @Autowired
    public DoctorService doctorService;
    @Autowired
    public PatientService patientService;
    @Autowired
    public RatingService ratingService;


    @RequestMapping(value = "/rate-doctor/{id}", method = RequestMethod.GET)
    public ModelAndView rate(@PathVariable(name = "id") Long id) {

        doctorSelected = doctorService.get(id);
        Patient patient = patientService.currentPatient();
        Rating rating = new Rating();
        ModelAndView mav = new ModelAndView("patient/rate-doctor");
        rating.setDoctor(doctorSelected);
        rating.setPatient(patientService.currentPatient());
     /*   mav.addObject("doctorSelected", doctorSelected);
        mav.addObject("doctorSelected", doctorSelected);*/
        mav.addObject("rating", rating);
        if (patient == null) {
            patient = new Patient();
            mav.addObject("patient", patient);
        } else {
            mav.addObject("patient", patient);
        }
        mav.addObject("doctorSelected", doctorSelected);

        return mav;
    }

    @RequestMapping(value = "/save-rating", method = RequestMethod.POST)
    public ModelAndView saveRating(@ModelAttribute("rating") @Valid Rating rating, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView();
            Patient patient = patientService.currentPatient();
            if (patient == null) {
                patient = new Patient();
                model.addObject("patient", patient);
            } else {
                model.addObject("patient", patient);
            }
            model.addObject("doctorSelected", doctorSelected);
            model.setViewName("patient/rate-doctor");
            return model;
        } else {
            Date testDate = new Date();
            ModelAndView mav = new ModelAndView("redirect:/patient");
            rating.setDoctor(doctorSelected);
            rating.setDate(testDate);
            rating.setPatient(patientService.currentPatient());

            ratingService.save(rating);
            Patient patient = patientService.currentPatient();
            if (patient == null) {
                patient = new Patient();
                mav.addObject("patient", patient);
            } else {
                mav.addObject("patient", patient);
            }

            return mav;
        }
    }

}
