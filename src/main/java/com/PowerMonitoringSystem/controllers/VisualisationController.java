package com.PowerMonitoringSystem.controllers;

import com.PowerMonitoringSystem.services.api.ElectricEnergy;
import com.PowerMonitoringSystem.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;


@Controller
public class VisualisationController {

    @Autowired
    private ElectricEnergy electricEnergy;

    @RequestMapping(value = { "/chart" }, method = RequestMethod.GET)
    public String chart(ModelMap modelMap) {
        Iterable<com.PowerMonitoringSystem.models.ElectricEnergy> canvasJsDataList = electricEnergy.findAll();
        modelMap.addAttribute("dataPointsList", canvasJsDataList);
        return "chart.html";
    }

    @RequestMapping(value = {"/table"}, method = RequestMethod.GET)
    public String table(ModelMap modelMap){
        Iterable<com.PowerMonitoringSystem.models.ElectricEnergy> tableData = electricEnergy.findAll();
        modelMap.addAttribute("tableData", tableData);
        return "tableData.html";
    }

    @RequestMapping( value = {"/sortTable"}, method = RequestMethod.POST)
    public String filterDate(@RequestParam("start-datetime") String fromDate,
                             @RequestParam("end-datetime") String toDate, Model model) throws ParseException {


        Timestamp tFrom = new Timestamp(DateUtil.provideDateFormat().parse(fromDate).getTime());
        Timestamp tTo = new Timestamp(DateUtil.provideDateFormat().parse(toDate).getTime());

         List<com.PowerMonitoringSystem.models.ElectricEnergy> tableData =
                electricEnergy.findAllByDateBetween(tFrom, tTo);
         model.addAttribute("tableData", tableData);


        return "tableData.html";
    }

    @RequestMapping( value = {"/sortChart"}, method = RequestMethod.POST)
    public String filterDateChart(@RequestParam("start-datetime") String fromDate,
                             @RequestParam("end-datetime") String toDate, Model model) throws ParseException {


        Timestamp tFrom = new Timestamp(DateUtil.provideDateFormat().parse(fromDate).getTime());
        Timestamp tTo = new Timestamp(DateUtil.provideDateFormat().parse(toDate).getTime());

        List<com.PowerMonitoringSystem.models.ElectricEnergy> ChartData =
                electricEnergy.findAllByDateBetween(tFrom, tTo);
        model.addAttribute("dataPointsList", ChartData);


        return "chart.html";
    }
}
