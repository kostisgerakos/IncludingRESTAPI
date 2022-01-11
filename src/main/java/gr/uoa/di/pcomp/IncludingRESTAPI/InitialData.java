package gr.uoa.di.pcomp.IncludingRESTAPI;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.DdlScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Equipment;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.EquipmentType;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Experiment;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentExecution;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentStatusLut;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Obstacle;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Operator;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.OperatorCategory;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Reservation;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationItem;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationStatus;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ResourceSpecification;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ResourceType;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Sensor;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.SensorType;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Testbed;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.TestbedArea;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.User;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.UxV;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.UxVSensor;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.UxVType;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.DdlScriptRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ExperimentExecutionRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ExperimentRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ExperimentStatusRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ObstacleRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ReservationRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ReservationStatusRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.TestbedAreaRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.TestbedRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.UserRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.EquipmentRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.EquipmentTypeRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.OperatorCategoryRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.OperatorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.ResourceRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.ResourceSpecificationRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.ResourceTypeRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.SensorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.SensorTypeRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.UxVRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.UxVSensorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.UxVTypeRepository;

@Component
public class InitialData implements ApplicationRunner {

    private TestbedRepository testbedRepository;
    private TestbedAreaRepository testbedAreaRepository;
	private SensorRepository sensorRepository;
    private OperatorRepository operatorRepository;
    private OperatorCategoryRepository operatorCategoryRepository;
    private ResourceTypeRepository resourceTypeRepository;
    private UserRepository userRepository;
    private UxVRepository uxvRepository;
    private UxVTypeRepository uxvTypeRepository;
    private UxVSensorRepository uxvSensorRepository;
    private ReservationRepository reservationRepository;
    private ResourceRepository resourceRepository;
    private SensorTypeRepository sensorTypeRepository;
    private ReservationStatusRepository reservationStatusRepository;
    private ObstacleRepository obstacleRepository;
    private ResourceSpecificationRepository resourceSpecificationRepository;
    private EquipmentRepository equipmentRepository;
    private EquipmentTypeRepository equipmentTypeRepository;
    private ExperimentRepository experimentRepository;
    private ExperimentStatusRepository experimentStatusRepository;
    private DdlScriptRepository ddlScriptRepository;
    private ExperimentExecutionRepository experimentExecutionRepository;

    

    
    public void run(ApplicationArguments args) {
    	
    	experimentStatusRepository.save(new ExperimentStatusLut(1,"BOOKED"));
    	experimentStatusRepository.save(new ExperimentStatusLut(2,"ONGOING"));
    	experimentStatusRepository.save(new ExperimentStatusLut(3,"COMPLETED"));
    	experimentStatusRepository.save(new ExperimentStatusLut(4,"BLOCKED"));
    	experimentStatusRepository.save(new ExperimentStatusLut(5,"CANCELLED"));
    	experimentStatusRepository.save(new ExperimentStatusLut(6,"FAILED"));
    	
    	sensorTypeRepository.save(new SensorType(null,"Static"));
    	sensorTypeRepository.save(new SensorType(null,"Mobile"));
    	
    	resourceTypeRepository.save(new ResourceType(1,"UxV"));
    	resourceTypeRepository.save(new ResourceType(2,"Equipment"));
    	resourceTypeRepository.save(new ResourceType(3,"Operator"));
    	resourceTypeRepository.save(new ResourceType(4,"Sensor"));

    	reservationStatusRepository.save(new ReservationStatus(null, "CANCELLED"));
    	reservationStatusRepository.save(new ReservationStatus(null, "CONFLICT"));
    	reservationStatusRepository.save(new ReservationStatus(null, "OK"));
    	reservationStatusRepository.save(new ReservationStatus(null, "PENDING"));
    	reservationStatusRepository.save(new ReservationStatus(null, "REJECTED"));

        uxvTypeRepository.save(new UxVType(1,"UAV")); 
        uxvTypeRepository.save(new UxVType(2,"UGV")); 
    	
    	equipmentTypeRepository.save(new EquipmentType(null, "Backpack"));
    	equipmentTypeRepository.save(new EquipmentType(null, "Heavy Backpack"));

    	resourceSpecificationRepository.save(new ResourceSpecification(null,14,55,31,65));

    	userRepository.save(new User(1, "test@email.com", "testi", "testus", "test", true, null,null, null));
    	userRepository.save(new User(2, "test2@email.com", "testi2", "testus2", "test2", true, null,null, null));
    	userRepository.save(new User(3, "test@email.com", "a", "testus3", "a", true, null,null, null));
    	userRepository.save(new User(4, "test2@email.com", "b", "testus4", "b", true, null,null, null));
    	

        testbedRepository.save(new Testbed(1 ,2.0, "+23.657844,+38.017445", "+23.657844,+38.017445", "Haidari"," Test Description", LocalTime.of(18, 0), LocalTime.of(10, 0), true, null, null, null, null, null, null));
        testbedAreaRepository.save(new TestbedArea(1, "Haidari_Geofence_Area", testbedRepository.getOne(1), null,"+23.657844,+38.017445", "((23.653716133580634, 38.018219649282436),(23.655497120366523, 38.0144667154302), (23.658243702397773, 38.01424694307741),(23.66176276062531 ,38.0146695816325), (23.662706898198554, 38.01565009369502),(23.66429476593537, 38.0157515252287), (23.665131615148017, 38.01656297244477),(23.665195988164374, 38.017442030124194),(23.666247414098212, 38.018101316464524),(23.667899654851386, 38.01842250509719),(23.66957335327668, 38.01842250509719), (23.670345829472968, 38.018692978643436),(23.670388744817206, 38.019402966952974),(23.669122742162177, 38.02190477569502),(23.66826443527741, 38.02276686567676), (23.668010703392028, 38.02317112958378),(23.663397303886413, 38.022528792535724),(23.661787978477477,38.021269457508424), (23.65893410808563, 38.02168360363061), (23.653716133580634, 38.018219649282436))"
        		, null, false, null, 0.0, null, null));
        obstacleRepository.save(new Obstacle(null,"((23.65976910,38.02049484),(23.65922981,38.01935473),(23.66046005,38.01858941),(23.66113239,38.02025595),(23.65975910,38.02048484))",testbedAreaRepository.getOne(1)));
        obstacleRepository.save(new Obstacle(null,"((23.66445833,38.01798144),(23.66218381,38.01756659),(23.66314941,38.01896134),(23.66445833,38.01798144))",testbedAreaRepository.getOne(1)));

       testbedRepository.save(new Testbed(2 ,2.0, "+23.609227,+37.963935", "+23.609227,+37.963935", "hmod"," Telonio", LocalTime.of(22, 0), LocalTime.of(2, 0), false, null, null, null, null, null, null));
        testbedAreaRepository.save(new TestbedArea(2, "Telonio_Geofence_HMOD", testbedRepository.getOne(2), null,"+23.609227,+37.963935", "((23.609227970703216,37.96393554120458),(23.6096463952822,37.96489135610939),(23.611137703397056,37.96477293723888),(23.61153467030533, 37.96363948981666),(23.610365227251236,37.96261598867959),(23.609442547410392, 37.962793622131414),(23.609227970703216, 37.96393554120458))"
        		, null, false, null, 0.0, null, null));
        obstacleRepository.save(new Obstacle(null,"((0.0,0.0),(0.0,0.1),(0.0,0.2),(0.0,0.0))",testbedAreaRepository.getOne(2)));

        
        
        sensorRepository.save(new Sensor(null, "sensor1", null, "+38.017445,+23.657844", null, null, true, false, null, null, null, resourceTypeRepository.getOne(4), testbedAreaRepository.getOne(1), "Sensor_Name_1", null, "Kelvin", sensorTypeRepository.getOne(1),null));
        sensorRepository.save(new Sensor(null, "sensor3", null, "+38.018445,+23.658844", null, null, true, false, null, null, null, resourceTypeRepository.getOne(4), testbedAreaRepository.getOne(1), "Sensor_Name_3", null, "Celsious", sensorTypeRepository.getOne(1),null));

        sensorRepository.save(new Sensor(null, "sensor2", null, null, null, null, false, true, null, null, null, resourceTypeRepository.getOne(4), testbedAreaRepository.getOne(1), "Sensor_Name 2", null, "Celsius", sensorTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));
        
        sensorRepository.save(new Sensor(null, "gamma_probe", null, null, 4, null, true, true, null, null, null, resourceTypeRepository.getOne(4), testbedAreaRepository.getOne(2), "Sensor_Name 2", null, "uS_h", sensorTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));

        operatorCategoryRepository.save(new OperatorCategory(1,"Firefighter"));
        operatorCategoryRepository.save(new OperatorCategory(2,"CBRN_Recce"));
        operatorCategoryRepository.save(new OperatorCategory(3,"CBRN_Sampling"));
        operatorCategoryRepository.save(new OperatorCategory(4,"CBRN_Marking"));
        operatorCategoryRepository.save(new OperatorCategory(5,"CBRN_Decontamination"));
        operatorCategoryRepository.save(new OperatorCategory(6,"Medical"));
        operatorCategoryRepository.save(new OperatorCategory(7,"General_Officer"));


        
        
        operatorRepository.save(new Operator(null, "CBRN_Recce_1", null, null, 11, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Recce_1", operatorCategoryRepository.getOne(2)));
        operatorRepository.save(new Operator(null, "CBRN_Recce_2", null, null, 12, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Recce_2", operatorCategoryRepository.getOne(2)));
        operatorRepository.save(new Operator(null, "CBRN_Recce_3", null, null, 13, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Recce_3", operatorCategoryRepository.getOne(2)));

        
        //operatorRepository.save(new Operator(null, "CBRN_Sampling_1", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Sampling_1", operatorCategoryRepository.getOne(2)));
        //operatorRepository.save(new Operator(null, "CBRN_Marking_1", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Marking_1", operatorCategoryRepository.getOne(3)));
        operatorRepository.save(new Operator(null, "CBRN_Decontamination_1", null, null, 14, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Decontamination_1", operatorCategoryRepository.getOne(4)));
        operatorRepository.save(new Operator(null, "CBRN_Medical_1", null, null, 15, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Medical_1", operatorCategoryRepository.getOne(5)));

        operatorRepository.save(new Operator(null, "General_Officer_1", null, null, 16, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "General_Officer_1", operatorCategoryRepository.getOne(7)));
        operatorRepository.save(new Operator(null, "General_Officer_2", null, null, 17, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "General_Officer_2", operatorCategoryRepository.getOne(7)));

        
        
    	equipmentRepository.save(new Equipment(null, "Backpacks", null, null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(2), testbedAreaRepository.getOne(1),10,equipmentTypeRepository.getOne(1)));
    	equipmentRepository.save(new Equipment(null, "Heavy_Backpacks", null, "+38.019445,+23.659844", null, null, true, false, null, null, null, resourceTypeRepository.getOne(2), testbedAreaRepository.getOne(1),20,equipmentTypeRepository.getOne(2)));
        
        /*uxvRepository.save(new UxV(null, "UGV1", "wizzit1", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),"Pressure,Light,Touch",resourceSpecificationRepository.getOne(1)));
        uxvRepository.save(new UxV(null, "UGV2", "wizzit2", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),"Pressure,Light,Touch",resourceSpecificationRepository.getOne(1)));
    	uxvRepository.save(new UxV(null, "UGV3", "wizzit3", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),"Pressure,Light,Touch",resourceSpecificationRepository.getOne(1)));
        */
    	
    

    	
    	uxvRepository.save(new UxV(null, "UGV1", "wizzit1", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));
        uxvRepository.save(new UxV(null, "Endeavour2", "Endeavour2", null, 31, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(2), uxvTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));
     	uxvRepository.save(new UxV(null, "Endeavour4", "Endeavour4", null, 33, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(2), uxvTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));
        
    	uxvSensorRepository.save(new UxVSensor(null,"pressure", null, null,uxvRepository.getByResourceId(17)));
    	uxvSensorRepository.save(new UxVSensor(null,"pressure", null, null,uxvRepository.getByResourceId(18)));
    	uxvSensorRepository.save(new UxVSensor(null,"pressure", null, null,uxvRepository.getByResourceId(19)));
    	
    	uxvSensorRepository.save(new UxVSensor(null,"light", null, null,uxvRepository.getByResourceId(17)));
    	uxvSensorRepository.save(new UxVSensor(null,"light", null, null,uxvRepository.getByResourceId(18)));

    	uxvSensorRepository.save(new UxVSensor(null,"touch", null, null,uxvRepository.getByResourceId(17)));
     	
    	//Reservation res1 = new Reservation(null,1, null, LocalDateTime.of(2021,2,3,15,0,0), LocalDateTime.of(2021,2,3,15,55,0), testbedAreaRepository.getOne(1), userRepository.getOne(1), Arrays.asList(new ReservationItem(null, null, null, null, null, null, null, resourceRepository.findByResourceId(5)),new ReservationItem(null, null, null, null, null, null, null, resourceRepository.findByResourceId(6))));
        Reservation res1 = new Reservation(null, reservationStatusRepository.getOne(4), LocalDateTime.of(2021,6,20,15,0,0), LocalDateTime.of(2021,6,20,15,55,0), testbedAreaRepository.getOne(1), userRepository.getOne(1));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(1)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(2)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(3)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(4)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(5)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(6)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(7)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(8)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(9)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(10)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(11)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(12)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(13)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(14)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(17)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(18)));
        res1.addReservationItem(new ReservationItem(null, null, res1, resourceRepository.findByResourceId(19)));

        reservationRepository.save(res1);
        
        Reservation res2 = new Reservation(null,reservationStatusRepository.getOne(4), LocalDateTime.of(2021,7,29,15,55,0), LocalDateTime.of(2021,7,29,16,15,0), testbedAreaRepository.getOne(1), userRepository.getOne(1));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(1)));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(2)));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(3)));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(5)));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(6)));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(7)));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(9)));
        res2.addReservationItem(new ReservationItem(null, null, res2, resourceRepository.findByResourceId(11)));

        reservationRepository.save(res2);
        
        Reservation res3 = new Reservation(null,reservationStatusRepository.getOne(4), LocalDateTime.of(2021,7,29,10,0,0), LocalDateTime.of(2021,7,29,11,15,0), testbedAreaRepository.getOne(1), userRepository.getOne(1));
        res3.addReservationItem(new ReservationItem(null, null, res3, resourceRepository.findByResourceId(1)));
        res3.addReservationItem(new ReservationItem(null, null, res3, resourceRepository.findByResourceId(3)));
        res3.addReservationItem(new ReservationItem(null,  null, res3, resourceRepository.findByResourceId(4)));
        res3.addReservationItem(new ReservationItem(null, null, res3, resourceRepository.findByResourceId(5)));
        res3.addReservationItem(new ReservationItem(null, null, res3, resourceRepository.findByResourceId(6)));
        res3.addReservationItem(new ReservationItem(null, null, res3, resourceRepository.findByResourceId(7)));
        res3.addReservationItem(new ReservationItem(null, null, res3, resourceRepository.findByResourceId(8)));
        res3.addReservationItem(new ReservationItem(null, null, res3, resourceRepository.findByResourceId(11)));
        
        reservationRepository.save(res3);
        
        Reservation res4 = new Reservation(null,reservationStatusRepository.getOne(4), LocalDateTime.of(2021,7,30,11,15,0), LocalDateTime.of(2021,7,30,12,15,0), testbedAreaRepository.getOne(1), userRepository.getOne(1));
        res4.addReservationItem(new ReservationItem(null, null, res4, resourceRepository.findByResourceId(1)));
        res4.addReservationItem(new ReservationItem(null, null, res4, resourceRepository.findByResourceId(3)));
        res4.addReservationItem(new ReservationItem(null,  null, res4, resourceRepository.findByResourceId(4)));
        res4.addReservationItem(new ReservationItem(null, null, res4, resourceRepository.findByResourceId(5)));
        res4.addReservationItem(new ReservationItem(null, null, res4, resourceRepository.findByResourceId(6)));
        res4.addReservationItem(new ReservationItem(null, null, res4, resourceRepository.findByResourceId(7)));
        res4.addReservationItem(new ReservationItem(null, null, res4, resourceRepository.findByResourceId(8)));
        res4.addReservationItem(new ReservationItem(null, null, res4, resourceRepository.findByResourceId(11)));
        
        reservationRepository.save(res4);
        
        Reservation res5 = new Reservation(null,reservationStatusRepository.getOne(4), LocalDateTime.of(2021,6,27,12,15,0), LocalDateTime.of(2021,6,27,13,15,0), testbedAreaRepository.getOne(1), userRepository.getOne(1));
        res5.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(1)));
        res5.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(3)));
        res5.addReservationItem(new ReservationItem(null,  null, res5, resourceRepository.findByResourceId(4)));
        res5.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(5)));
        res5.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(6)));
        res5.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(7)));
        res5.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(8)));
        res5.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(11)));
        
        reservationRepository.save(res5);
        
        Reservation res6 = new Reservation(null,reservationStatusRepository.getOne(4), LocalDateTime.of(2021,6,27,12,15,0), LocalDateTime.of(2021,6,27,13,15,0), testbedAreaRepository.getOne(2), userRepository.getOne(1));
        res6.addReservationItem(new ReservationItem(null, null, res5, resourceRepository.findByResourceId(10)));
   
        
        reservationRepository.save(res6);
        //reservationRepository.save(new Reservation(null,1, null, LocalDateTime.of(2021,2,3,15,0,0), LocalDateTime.of(2021,2,3,15,55,0), testbedAreaRepository.getOne(1), userRepository.getOne(1), Arrays.asList(new ReservationItem(null, null, null, null, null, null, null, resourceRepository.findByResourceId(5)),new ReservationItem(null, null, null, null, null, null, null, resourceRepository.findByResourceId(6)))));
        //reservationRepository.save(new Reservation(null, LocalDateTime.of(2021,2,3,15,0,0), LocalDateTime.of(2021,2,3,16,55,0), testbedAreaRepository.getOne(1), userRepository.getOne(1), Arrays.asList(new ReservationItem(null, null, null, null, null, null, null, resourceRepository.findByResourceId(6)))));
        //reservationRepository.save(new Reservation(null, LocalDateTime.of(2021,2,3,14,0,0), LocalDateTime.of(2021,2,3,15,55,0), testbedAreaRepository.getOne(1), userRepository.getOne(1), Arrays.asList(new ReservationItem(null, null, null, null, null, null, null, resourceRepository.findByResourceId(7)))));

        ddlScriptRepository.save(new DdlScript(1,null,null,null,null,"[\n" + 
        		"   {\n" + 
        		"      \"MetaInfo\":[\n" + 
        		"         {\n" + 
        		"            \"Username\":\"test\",\n" + 
        		"            \"Date\":\"27-06-2021\",\n" + 
        		"            \"selectedTime\":\"12:15\",\n" + 
        		"            \"startTime\":\"12:15\",\n" + 
        		"            \"endTime\":\"13:15\",\n" + 
        		"            \"Version\":\"0.04\",\n" + 
        		"            \"TestBedArea\":\"Telonio_Geofence_HMOD\",\n" + 
        		"            \"Longitude\":\"+37.963935\",\n" + 
        		"            \"Latitude\":\"+23.609227\",\n" + 
        		"            \"Polygon\":\"((23.609227970703216,37.96393554120458),(23.6096463952822,37.96489135610939),(23.611137703397056,37.96477293723888),(23.61153467030533, 37.96363948981666),(23.610365227251236,37.96261598867959),(23.609442547410392, 37.962793622131414),(23.609227970703216, 37.96393554120458))\",\n" + 
        		"            \"Obstacles\":[\n" + 
        		"               \"((0,0),(0,0.1),(0,0.2),(0,0))\"\n" + 
        		"            ],\n" + 
        		"            \"type\":\"outdoor\"\n" + 
        		"         }\n" + 
        		"      ]\n" + 
        		"   },\n" + 
        		"   {\n" + 
        		"      \"Image\":\"image for CBRN_Recce_1\",\n" + 
        		"      \"Name\":\"CBRN_Recce_1\",\n" + 
        		"      \"Type\":\"Operator\",\n" + 
        		"      \"Status\":null,\n" + 
        		"      \"Selected\":null,\n" + 
        		"      \"MinSpeed\":0,\n" + 
        		"      \"MaxSpeed\":1,\n" + 
        		"      \"Speed\":0,\n" + 
        		"      \"MinAltitude\":0,\n" + 
        		"      \"MaxAltitude\":1,\n" + 
        		"      \"Altitude\":0,\n" + 
        		"      \"availableSensors\":null,\n" + 
        		"      \"availableAlgorithms\":null,\n" + 
        		"      \"availableCommunications\":null,\n" + 
        		"      \"definedSensorsList\":[\n" + 
        		"         \n" + 
        		"      ],\n" + 
        		"      \"definedAlgorithmsList\":[\n" + 
        		"         \n" + 
        		"      ],\n" + 
        		"      \"definedCommunicationsList\":[\n" + 
        		"         \n" + 
        		"      ],\n" + 
        		"      \"definedEventsList\":null,\n" + 
        		"      \"definedWayPoints\":[\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":0,\n" + 
        		"            \"timestep\":0,\n" + 
        		"            \"longitude\":23.609744846620682,\n" + 
        		"            \"latitude\":37.964288083405215,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":57.6464221232753,\n" + 
        		"            \"y\":36.015161960101764\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":1,\n" + 
        		"            \"timestep\":1,\n" + 
        		"            \"longitude\":23.610101408959085,\n" + 
        		"            \"latitude\":37.964322222352514,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":39.69233794712773,\n" + 
        		"            \"y\":3.4822221628984438\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":2,\n" + 
        		"            \"timestep\":2,\n" + 
        		"            \"longitude\":23.610393486619266,\n" + 
        		"            \"latitude\":37.9642008394288,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":32.51393640338044,\n" + 
        		"            \"y\":-12.381200676957151\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":3,\n" + 
        		"            \"timestep\":3,\n" + 
        		"            \"longitude\":23.610636252466687,\n" + 
        		"            \"latitude\":37.96390496855226,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":27.024570516915666,\n" + 
        		"            \"y\":-30.17910940261979\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":4,\n" + 
        		"            \"timestep\":4,\n" + 
        		"            \"longitude\":23.610659011764884,\n" + 
        		"            \"latitude\":37.96343840293924,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":2.53355348612151,\n" + 
        		"            \"y\":-47.590045919474946\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":5,\n" + 
        		"            \"timestep\":5,\n" + 
        		"            \"longitude\":23.610507283110245,\n" + 
        		"            \"latitude\":37.963013562706244,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":-16.890356573220597,\n" + 
        		"            \"y\":-43.33401802893521\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":6,\n" + 
        		"            \"timestep\":6,\n" + 
        		"            \"longitude\":23.610131754690013,\n" + 
        		"            \"latitude\":37.96286942048434,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":-41.80363251863199,\n" + 
        		"            \"y\":-14.702630278338603\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":7,\n" + 
        		"            \"timestep\":7,\n" + 
        		"            \"longitude\":23.609722087322485,\n" + 
        		"            \"latitude\":37.96316149814452,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":-45.60396274781426,\n" + 
        		"            \"y\":29.792257231203667\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":8,\n" + 
        		"            \"timestep\":8,\n" + 
        		"            \"longitude\":23.60947173504233,\n" + 
        		"            \"latitude\":37.96348392153563,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":-27.869088345754665,\n" + 
        		"            \"y\":32.88765946506218\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"wayPoint\":9,\n" + 
        		"            \"timestep\":9,\n" + 
        		"            \"longitude\":23.609847263462562,\n" + 
        		"            \"latitude\":37.96367737557029,\n" + 
        		"            \"altitude\":0,\n" + 
        		"            \"speed\":0,\n" + 
        		"            \"x\":41.80363251863199,\n" + 
        		"            \"y\":19.732633365598485\n" + 
        		"         }\n" + 
        		"      ],\n" + 
        		"      \"WPs\":null,\n" + 
        		"      \"borrowed\":true,\n" + 
        		"      \"location\":null,\n" + 
        		"      \"definedTasksList\":[\n" + 
        		"         {\n" + 
        		"            \"duration\":\"1\",\n" + 
        		"            \"time\":0,\n" + 
        		"            \"command\":\"Develop decontamination lines\"\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"duration\":\"1\",\n" + 
        		"            \"time\":1,\n" + 
        		"            \"command\":\"Approach the container\"\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"duration\":\"1\",\n" + 
        		"            \"time\":2,\n" + 
        		"            \"command\":\"Enter the container for further check\"\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"duration\":\"1\",\n" + 
        		"            \"time\":3,\n" + 
        		"            \"command\":\"Check the rest of the personnel for possible contamination before they proceed to the decontamination zones\"\n" + 
        		"         },\n" + 
        		"         {\n" + 
        		"            \"duration\":\"1\",\n" + 
        		"            \"time\":4,\n" + 
        		"            \"command\":\"Establish incident perimeter\"\n" + 
        		"         }\n" + 
        		"      ]\n" + 
        		"   }\n" + 
        		"]"));
        experimentRepository.save(new Experiment(1,"name", null, null, "0.22", null, ddlScriptRepository.getOne(1), experimentStatusRepository.getOne(2), userRepository.getOne(1)));
        
        ddlScriptRepository.save(new DdlScript(2,"VE-Sim",null,"VE-Sim","{\n" + 
        		"      \"data\": [\n" + 
        		"        {\n" + 
        		"          \"location\": [\n" + 
        		"            {\n" + 
        		"              \"timestep\": 0.0\n" + 
        		"            },\n" + 
        		"            {\n" + 
        		"              \"nodes\": [\n" + 
        		"                {\n" + 
        		"                  \"nodeCommand\": \"goto\",\n" + 
        		"                  \"node\": \"23.657144,38.017445,0.0\"\n" + 
        		"                },\n" + 
        		"                {\n" + 
        		"                  \"nodeCommand\": \"goto\",\n" + 
        		"                  \"node\": \"23.658844,38.018445,0.0\"\n" + 
        		"                },\n" + 
        		"                {\n" + 
        		"                  \"nodeCommand\": \"goto\",\n" + 
        		"                  \"node\": \"23.658844,38.018445,0.0\"\n" + 
        		"                }\n" + 
        		"              ],\n" + 
        		"              \"sensors\": [\n" + 
        		"                {\n" + 
        		"                  \"sensorsActDeact\": \"\"\n" + 
        		"                },\n" + 
        		"                {\n" + 
        		"                  \"sensorsActDeact\": \"\"\n" + 
        		"                },\n" + 
        		"                {\n" + 
        		"                  \"sensorsActDeact\": \"\"\n" + 
        		"                }\n" + 
        		"              ],\n" + 
        		"              \"tasks\": [\n" + 
        		"                [{\n" + 
        		"                  \"command\": \"B2_B7\",\n" + 
        		"                  \"duration\": 1\n" + 
        		"                }\n" + 
        		"                ],\n" + 
        		"                [],\n" + 
        		"                []\n" + 
        		"              ]\n" + 
        		"            }\n" + 
        		"          ]\n" + 
        		"        }\n" + 
        		"      ],\n" + 
        		"      \"nodeNames\": [\n" + 
        		"        {\n" + 
        		"          \"nodeName\": \"res1\"\n" + 
        		"        },\n" + 
        		"        {\n" + 
        		"          \"nodeName\": \"res2\"\n" + 
        		"        },\n" + 
        		"        {\n" + 
        		"          \"nodeName\": \"Trainee 1\"\n" + 
        		"        }\n" + 
        		"      ],\n" + 
        		"      \"Area\": \"Haidari_geofence_area\"\n" + 
        		"    }","script"));
        
        
        experimentRepository.save(new Experiment(2,"For VE simulation", null, "E_Sim", "1", null, ddlScriptRepository.getOne(2), experimentStatusRepository.getOne(2), userRepository.getOne(1)));
        
        testbedRepository.save(new Testbed(3 ,2.0, "+23.657844,+38.017445", "+23.657844,+38.017445","VE_Sim_Haidari", "Test Description", LocalTime.of(18, 0), LocalTime.of(10, 0), true, null, null, null, null, null, null));
        testbedAreaRepository.save(new TestbedArea(3, "VE_Sim_Haidari_geofence_area", testbedRepository.getOne(3), "Test Description","+23.657844,+38.017445", "((23.653716133580634, 38.018219649282436),(23.655497120366523, 38.0144667154302), (23.658243702397773, 38.01424694307741),(23.66176276062531 ,38.0146695816325), (23.662706898198554, 38.01565009369502),(23.66429476593537, 38.0157515252287), (23.665131615148017, 38.01656297244477),(23.665195988164374, 38.017442030124194),(23.666247414098212, 38.018101316464524),(23.667899654851386, 38.01842250509719),(23.66957335327668, 38.01842250509719), (23.670345829472968, 38.018692978643436),(23.670388744817206, 38.019402966952974),(23.669122742162177, 38.02190477569502),(23.66826443527741, 38.02276686567676), (23.668010703392028, 38.02317112958378),(23.663397303886413, 38.022528792535724),(23.661787978477477,38.021269457508424), (23.65893410808563, 38.02168360363061), (23.653716133580634, 38.018219649282436))"
        		, null, false, null, 0.0, null, null));
        
        testbedRepository.save(new Testbed(4 ,2.0, "+27.196844,+61.725409", "+27.196844,+61.725409","FTX_Mikkeli", "Joint action on Mikkeli", LocalTime.of(18, 0), LocalTime.of(10, 0), true, null, null, null, null, null, null));
        testbedAreaRepository.save(new TestbedArea(4, "FTX_Mikkeli_geofence_area", testbedRepository.getOne(4), "Joint action on Mikkeli","+27.196844,+61.725409", "((27.196844,61.725409),(27.204881,61.723558),(27.199077,61.718723), (27.190879,61.721872), (27.196844,61.725409))"
        		, null, false, null, 0.0, null, null));
        
        
        operatorRepository.save(new Operator(null, "operators1", null, null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(4), "OperatorName1", operatorCategoryRepository.getOne(1)));
        operatorRepository.save(new Operator(null, "operators2", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(4), "OperatorName2", operatorCategoryRepository.getOne(2)));
        operatorRepository.save(new Operator(null, "operators3", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(4), "OperatorName3", operatorCategoryRepository.getOne(3)));
        operatorRepository.save(new Operator(null, "operators4", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(4), "OperatorName4", operatorCategoryRepository.getOne(4)));
        operatorRepository.save(new Operator(null, "operators5", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(4),"OperatorName5", operatorCategoryRepository.getOne(5)));
        operatorRepository.save(new Operator(null, "operators6", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(4), "OperatorName6", operatorCategoryRepository.getOne(6)));
	
        
        
        experimentExecutionRepository.save(new ExperimentExecution(1,null,2,null,null,experimentRepository.getOne(2)));
        
        String teloneioScript = "[{\"MetaInfo\":[{\"Username\":\"test\",\"Date\":\"20-06-2021\",\"selectedTime\":\"15:00\",\"startTime\":\"15:00\",\"endTime\":\"15:55\",\"Version\":\"0.02\",\"TestBedArea\":\"Haidari_Geofence_Area\",\"Longitude\":\"+38.017445\",\"Latitude\":\"+23.657844\",\"Polygon\":\"((23.653716133580634, 38.018219649282436),(23.655497120366523, 38.0144667154302), (23.658243702397773, 38.01424694307741),(23.66176276062531 ,38.0146695816325), (23.662706898198554, 38.01565009369502),(23.66429476593537, 38.0157515252287), (23.665131615148017, 38.01656297244477),(23.665195988164374, 38.017442030124194),(23.666247414098212, 38.018101316464524),(23.667899654851386, 38.01842250509719),(23.66957335327668, 38.01842250509719), (23.670345829472968, 38.018692978643436),(23.670388744817206, 38.019402966952974),(23.669122742162177, 38.02190477569502),(23.66826443527741, 38.02276686567676), (23.668010703392028, 38.02317112958378),(23.663397303886413, 38.022528792535724),(23.661787978477477,38.021269457508424), (23.65893410808563, 38.02168360363061), (23.653716133580634, 38.018219649282436))\",\"Obstacles\":[\"((23.6597691,38.02049484),(23.65922981,38.01935473),(23.66046005,38.01858941),(23.66113239,38.02025595),(23.6597591,38.02048484))\",\"((23.66445833,38.01798144),(23.66218381,38.01756659),(23.66314941,38.01896134),(23.66445833,38.01798144))\"],\"type\":\"outdoor\"}]},{\"Image\":\"image for sensor1\",\"Name\":\"sensor1\",\"Type\":\"StaticSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":null,\"MaxSpeed\":null,\"Speed\":null,\"MinAltitude\":null,\"MaxAltitude\":null,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.657844,\"latitude\":38.017445,\"altitude\":0,\"speed\":0}],\"WPs\":null,\"borrowed\":true,\"location\":[{\"altitude\":0,\"latitude\":38.017445,\"longitude\":23.657844,\"speed\":0,\"timestep\":0,\"wayPoint\":0}],\"definedTasksList\":[]},{\"Image\":\"image for sensor3\",\"Name\":\"sensor3\",\"Type\":\"StaticSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":null,\"MaxSpeed\":null,\"Speed\":null,\"MinAltitude\":null,\"MaxAltitude\":null,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.658844,\"latitude\":38.018445,\"altitude\":0,\"speed\":0}],\"WPs\":null,\"borrowed\":true,\"location\":[{\"altitude\":0,\"latitude\":38.018445,\"longitude\":23.658844,\"speed\":0,\"timestep\":0,\"wayPoint\":0}],\"definedTasksList\":[]},{\"Image\":\"image for sensor2\",\"Name\":\"sensor2\",\"Type\":\"MobileSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":false,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for gamma_probe\",\"Name\":\"gamma_probe\",\"Type\":\"MobileSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators1\",\"Name\":\"operators1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators2\",\"Name\":\"operators2\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators3\",\"Name\":\"operators3\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators4\",\"Name\":\"operators4\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators5\",\"Name\":\"operators5\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators6\",\"Name\":\"operators6\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Recce_1\",\"Name\":\"CBRN_Recce_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Sampling_1\",\"Name\":\"CBRN_Sampling_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Marking_1\",\"Name\":\"CBRN_Marking_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Decontamination_1\",\"Name\":\"CBRN_Decontamination_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for Heavy_Backpacks\",\"Name\":\"Heavy_Backpacks\",\"Type\":\"Equipment\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.659844,\"latitude\":38.019445,\"altitude\":0,\"speed\":0}],\"WPs\":null,\"borrowed\":true,\"location\":[{\"altitude\":0,\"latitude\":38.019445,\"longitude\":23.659844,\"speed\":0,\"timestep\":0,\"wayPoint\":0}],\"definedTasksList\":[]},{\"Image\":\"image for UGV1\",\"Name\":\"UGV1\",\"Type\":\"UGV\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":[\"pressure\",\"light\"],\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for UGV2\",\"Name\":\"UGV2\",\"Type\":\"UGV\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":[\"pressure\"],\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]}]";
        String teloneioRealScript = "{\"data\":[{\"location\":[{\"timestep\":0.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.60973042192286,37.96298969952904,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Approach_incident_scene_search_ship_containers_and_secure_scene\",\"duration\":1}]]}]},{\"location\":[{\"timestep\":1.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.609976967714136,37.96294802981784,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Develop_decontamination_lines\",\"duration\":1}]]}]},{\"location\":[{\"timestep\":2.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.61019920617388,37.96294802981784,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[]]}]},{\"location\":[{\"timestep\":3.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.61039366482616,37.96307998390331,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Approach_the_container\",\"duration\":1}]]}]},{\"location\":[{\"timestep\":4.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.6105325638635,37.96303136924024,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Enter_the_container_for_further_check\",\"duration\":1}]]}]}],\"nodeNames\":[{\"nodeName\":\"CBRN_Recce_1\"}],\"Area\":\"Telonio_Geofence_HMOD\"}";
      
        ddlScriptRepository.save(new DdlScript(null,"Telonio",null,"Telonio",teloneioRealScript,teloneioScript));
        //experimentRepository.save(new Experiment(3,"Telonio", null, "Telonio", "16.01", null, ddlScriptRepository.getOne(3), null, userRepository.getOne(1)));
        
        experimentRepository.save(new Experiment(3,"Telonio", null, "Telonio", "16.01", null, ddlScriptRepository.getOne(3), experimentStatusRepository.getOne(2), userRepository.getOne(1)));

        
        String teloneioScript_1 = "[{\"MetaInfo\":[{\"Username\":\"test\",\"Date\":\"21-06-2021\",\"selectedTime\":\"11:36\",\"startTime\":\"09:36\",\"endTime\":\"14:00\",\"Version\":\"21.01\",\"TestBedArea\":\"Telonio_Geofence_HMOD\",\"Longitude\":\"+37.963935\",\"Latitude\":\"+23.609227\",\"Polygon\":\"((23.609227970703216,37.96393554120458),(23.6096463952822,37.96489135610939),(23.611137703397056,37.96477293723888),(23.61153467030533, 37.96363948981666),(23.610365227251236,37.96261598867959),(23.609442547410392, 37.962793622131414),(23.609227970703216, 37.96393554120458))\",\"Obstacles\":[\"((0,0),(0,0.1),(0,0.2),(0,0))\"],\"type\":\"outdoor\"}]},{\"Image\":\"image for General_Officer_2\",\"Name\":\"General_Officer_2\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.611011292531142,\"latitude\":37.96446638663171,\"altitude\":0,\"speed\":0,\"x\":198.62653599289274,\"y\":54.202421642886684},{\"wayPoint\":1,\"timestep\":1,\"longitude\":23.611011292531142,\"latitude\":37.96441804411885,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":-4.930958819565134},{\"wayPoint\":2,\"timestep\":2,\"longitude\":23.611011292531142,\"latitude\":37.96441804411885,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":3,\"timestep\":3,\"longitude\":23.611011292531142,\"latitude\":37.96441804411885,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":4,\"timestep\":4,\"longitude\":23.611011292531142,\"latitude\":37.96441804411885,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":5,\"timestep\":5,\"longitude\":23.610946835847333,\"latitude\":37.96441804411885,\"altitude\":0,\"speed\":0,\"x\":-7.175285219847093,\"y\":0},{\"wayPoint\":6,\"timestep\":6,\"longitude\":23.610946835847333,\"latitude\":37.96441804411885,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":7,\"timestep\":7,\"longitude\":23.610946835847333,\"latitude\":37.96441804411885,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":8,\"timestep\":8,\"longitude\":23.610914607505425,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":-3.587642610319033,\"y\":1.6436537481199454},{\"wayPoint\":9,\"timestep\":9,\"longitude\":23.61088237916352,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":-3.5876426099235466,\"y\":0},{\"wayPoint\":10,\"timestep\":10,\"longitude\":23.61086626499257,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":-1.7938213047640303,\"y\":0},{\"wayPoint\":11,\"timestep\":11,\"longitude\":23.610753465795902,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":-12.556749134930156,\"y\":0},{\"wayPoint\":12,\"timestep\":12,\"longitude\":23.610656780770185,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":-10.762927830166126,\"y\":0},{\"wayPoint\":13,\"timestep\":13,\"longitude\":23.610576209915422,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":-8.96910652500661,\"y\":0},{\"wayPoint\":14,\"timestep\":14,\"longitude\":23.610576209915422,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":15,\"timestep\":15,\"longitude\":23.610576209915422,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":16,\"timestep\":16,\"longitude\":23.610576209915422,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":17,\"timestep\":17,\"longitude\":23.610576209915422,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":18,\"timestep\":18,\"longitude\":23.610576209915422,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":19,\"timestep\":19,\"longitude\":23.610576209915422,\"latitude\":37.964434158289805,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[{\"duration\":\"1\",\"time\":0,\"command\":\"Approach incident scene search ship containers and deploy to the incident area\"},{\"duration\":\"1\",\"time\":1,\"command\":\"Establish and Develop decontamination lines \"},{\"duration\":\"1\",\"time\":5,\"command\":\"recce 1 Approach the area and check the customs worker and the coast guards for possible decontamination\"},{\"duration\":\"1\",\"time\":6,\"command\":\"recce 1 Enter the container to check for possible radiatio\"},{\"duration\":\"1\",\"time\":7,\"command\":\"recce 1 Element leader check the elements for possible decontamination \"},{\"duration\":\"1\",\"time\":8,\"command\":\"Recce 1 Proceed to decontamination line \"},{\"duration\":\"1\",\"time\":9,\"command\":\"recce 2 Enter the container to remove and shield the source \"},{\"duration\":\"1\",\"time\":10,\"command\":\"recce 2 Once the source is shielded enter the container for further check\"},{\"duration\":\"1\",\"time\":11,\"command\":\"Recce 2 Element leader check the elements for possible decontamination\"},{\"duration\":\"1\",\"time\":12,\"command\":\"Recce 2 Proceed to decontamination line\"},{\"duration\":\"1\",\"time\":13,\"command\":\"recce 3  Enter the container to remove and isolate the second source\"},{\"duration\":\"1\",\"time\":14,\"command\":\"recce 3 Once the source is shielded enter the container for further check\"},{\"duration\":\"1\",\"time\":15,\"command\":\"recce 3 Element leader check the elements  the vehicle and the safety box for possible decontamination \"},{\"duration\":\"1\",\"time\":16,\"command\":\"recce 3  Transport the shielded sources to GAEC\"},{\"duration\":\"1\",\"time\":17,\"command\":\"medical Activation for casualty care purposes\"},{\"duration\":\"1\",\"time\":18,\"command\":\"decontamination Establish incident perimeter if needed\"},{\"duration\":\"1\",\"time\":19,\"command\":\"End of exercise\"}]},{\"Image\":\"image for General_Officer_1\",\"Name\":\"General_Officer_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.610804376403845,\"latitude\":37.96461633804494,\"altitude\":0,\"speed\":0,\"x\":175.59273806526753,\"y\":69.49774380690461},{\"wayPoint\":1,\"timestep\":1,\"longitude\":23.61061951300733,\"latitude\":37.96464994957158,\"altitude\":0,\"speed\":0,\"x\":-20.57889916647857,\"y\":3.4283967783013067},{\"wayPoint\":2,\"timestep\":2,\"longitude\":23.610367426557538,\"latitude\":37.96468356109822,\"altitude\":0,\"speed\":0,\"x\":-28.062135226620743,\"y\":3.428401613477783},{\"wayPoint\":3,\"timestep\":3,\"longitude\":23.6102497862143,\"latitude\":37.964672357256006,\"altitude\":0,\"speed\":0,\"x\":-13.09566310594091,\"y\":-1.1428027356142443},{\"wayPoint\":4,\"timestep\":4,\"longitude\":23.610137747792173,\"latitude\":37.96460513420273,\"altitude\":0,\"speed\":0,\"x\":-12.472060100500617,\"y\":-6.856822567447329},{\"wayPoint\":5,\"timestep\":5,\"longitude\":23.61003131129115,\"latitude\":37.964588328439405,\"altitude\":0,\"speed\":0,\"x\":-11.848457095851296,\"y\":-1.7142071073988907},{\"wayPoint\":6,\"timestep\":6,\"longitude\":23.609863253657952,\"latitude\":37.96456592075498,\"altitude\":0,\"speed\":0,\"x\":-18.70809015134415,\"y\":-2.2856113319285094},{\"wayPoint\":7,\"timestep\":7,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":-8.730442070231785,\"y\":-3.4284213933735352},{\"wayPoint\":8,\"timestep\":8,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":9,\"timestep\":9,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":10,\"timestep\":10,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":11,\"timestep\":11,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":12,\"timestep\":12,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":13,\"timestep\":13,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":14,\"timestep\":14,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":15,\"timestep\":15,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":16,\"timestep\":16,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":17,\"timestep\":17,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":18,\"timestep\":18,\"longitude\":23.609784826762464,\"latitude\":37.96453230922834,\"altitude\":0,\"speed\":0,\"x\":0,\"y\":0},{\"wayPoint\":19,\"timestep\":19,\"longitude\":23.60967381634208,\"latitude\":37.96446638663171,\"altitude\":0,\"speed\":0,\"x\":-12.357623469804524,\"y\":-6.724198464001492}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[{\"duration\":\"1\",\"time\":0,\"command\":\"Approach incident scene search ship containers and deploy to the incident area\"},{\"duration\":\"1\",\"time\":1,\"command\":\"Establish - Develop decontamination lines and equipment \"},{\"duration\":\"1\",\"time\":5,\"command\":\"Recce 1 Approach the area and check the customs worker and the coast guards for possible decontamination\"},{\"duration\":\"1\",\"time\":6,\"command\":\"Recce 1 Enter the container to check for possible radiation\"},{\"duration\":\"1\",\"time\":7,\"command\":\"Recce 1 Element leader check the elements for possible decontamination\"},{\"duration\":\"1\",\"time\":8,\"command\":\"Recce 1 Proceed to decontamination line\"},{\"duration\":\"1\",\"time\":9,\"command\":\"Recce 2 Enter the container to remove and shield the source\"},{\"duration\":\"1\",\"time\":10,\"command\":\"Recce 2  Once the source is shielded enter the container for further check\"},{\"duration\":\"1\",\"time\":11,\"command\":\"Recce 2  Element leader check the elements for possible decontamination\"},{\"duration\":\"1\",\"time\":12,\"command\":\"Recce 2 Proceed to decontamination line \"},{\"duration\":\"1\",\"time\":13,\"command\":\"Recce 3 Enter the container to remove and isolate the second source\"},{\"duration\":\"1\",\"time\":14,\"command\":\"Recce 3 Once the source is shielded enter the container for further check\"},{\"duration\":\"1\",\"time\":15,\"command\":\"Recce 3 Element leader check the elements the vehicle and the safety box for possible decontamination\"},{\"duration\":\"1\",\"time\":16,\"command\":\"Transport the shielded sources to GAEC \"},{\"duration\":\"1\",\"time\":17,\"command\":\"Medical Activation for casualty care purposes\"},{\"duration\":\"1\",\"time\":18,\"command\":\"Decontamination Establish incident perimeter if needed\"},{\"duration\":\"1\",\"time\":19,\"command\":\"End of exercise\"}]},{\"Image\":\"image for CBRN_Recce_3\",\"Name\":\"CBRN_Recce_3\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.61126687606516,\"latitude\":37.96384968343314,\"altitude\":0,\"speed\":0,\"x\":227.0779648547859,\"y\":-8.70244799942404},{\"wayPoint\":1,\"timestep\":13,\"longitude\":23.611162556698794,\"latitude\":37.96383529455502,\"altitude\":0,\"speed\":0,\"x\":-11.61277874360551,\"y\":-1.467669405804064},{\"wayPoint\":2,\"timestep\":14,\"longitude\":23.611097806747257,\"latitude\":37.96381371123784,\"altitude\":0,\"speed\":0,\"x\":-7.207931634030228,\"y\":-2.20150586046843},{\"wayPoint\":3,\"timestep\":15,\"longitude\":23.61104744567384,\"latitude\":37.96381371123784,\"altitude\":0,\"speed\":0,\"x\":-5.606169048514405,\"y\":0},{\"wayPoint\":4,\"timestep\":16,\"longitude\":23.610957515185596,\"latitude\":37.96380291957925,\"altitude\":0,\"speed\":0,\"x\":-10.011016158089687,\"y\":-1.1007538969194761},{\"wayPoint\":5,\"timestep\":19,\"longitude\":23.61088197357547,\"latitude\":37.963795725140194,\"altitude\":0,\"speed\":0,\"x\":-8.409253572969352,\"y\":-0.733836434517911}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[{\"duration\":\"1\",\"time\":0,\"command\":\"Approach incident scene search ship containers and deploy to the incident area\"},{\"duration\":\"1\",\"time\":13,\"command\":\"Enter the container to remove and isolate the second source\"},{\"duration\":\"1\",\"time\":14,\"command\":\"Once the source is shielded enter the container for further check\"},{\"duration\":\"1\",\"time\":15,\"command\":\"Element leader check the elements  the vehicle and the safety box for possible decontamination \"},{\"duration\":\"1\",\"time\":16,\"command\":\"Transport the shielded sources to GAEC\"},{\"duration\":\"1\",\"time\":19,\"command\":\"End of exercise\"}]},{\"Image\":\"image for CBRN_Recce_2\",\"Name\":\"CBRN_Recce_2\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.61124529274798,\"latitude\":37.96391443338468,\"altitude\":0,\"speed\":0,\"x\":224.67532097690767,\"y\":-2.0978328937353625},{\"wayPoint\":1,\"timestep\":9,\"longitude\":23.611137376162088,\"latitude\":37.96391443338468,\"altitude\":0,\"speed\":0,\"x\":-12.013219389786721,\"y\":0},{\"wayPoint\":2,\"timestep\":10,\"longitude\":23.61102945957619,\"latitude\":37.96390004450656,\"altitude\":0,\"speed\":0,\"x\":-12.013219390182208,\"y\":-1.4676708558375793},{\"wayPoint\":3,\"timestep\":11,\"longitude\":23.61092514020983,\"latitude\":37.96388565562844,\"altitude\":0,\"speed\":0,\"x\":-11.612778743210022,\"y\":-1.467672064193115},{\"wayPoint\":4,\"timestep\":12,\"longitude\":23.610835209721582,\"latitude\":37.963882058408906,\"altitude\":0,\"speed\":0,\"x\":-10.011016158485173,\"y\":-0.3669183082474851},{\"wayPoint\":5,\"timestep\":13,\"longitude\":23.610759668111456,\"latitude\":37.96389644728703,\"altitude\":0,\"speed\":0,\"x\":-8.409253572969352,\"y\":1.4676742392199578},{\"wayPoint\":6,\"timestep\":19,\"longitude\":23.610694918159922,\"latitude\":37.96388925284797,\"altitude\":0,\"speed\":0,\"x\":-7.2079316336347405,\"y\":-0.7338375421672079}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[{\"duration\":\"1\",\"time\":0,\"command\":\"Approach incident scene search ship containers and deploy to the incident area\"},{\"duration\":\"1\",\"time\":9,\"command\":\"Enter the container to remove and shield the source\"},{\"duration\":\"1\",\"time\":10,\"command\":\"Once the source is shielded enter the container for further check\"},{\"duration\":\"1\",\"time\":11,\"command\":\"Element leader check the elements for possible decontamination\"},{\"duration\":\"1\",\"time\":12,\"command\":\"Proceed to decontamination line\"},{\"duration\":\"1\",\"time\":18,\"command\":\"Establish incident perimeter if needed\"},{\"duration\":\"1\",\"time\":19,\"command\":\"End of exercise\"}]},{\"Image\":\"image for CBRN_Medical_1\",\"Name\":\"CBRN_Medical_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.61123722408472,\"latitude\":37.963748918739434,\"altitude\":0,\"speed\":0,\"x\":223.77712149149903,\"y\":-18.980633578396215},{\"wayPoint\":1,\"timestep\":17,\"longitude\":23.611032879075022,\"latitude\":37.96369959408192,\"altitude\":0,\"speed\":0,\"x\":-22.74758242585315,\"y\":-5.031129358922584},{\"wayPoint\":2,\"timestep\":19,\"longitude\":23.61084967320426,\"latitude\":37.9636643621837,\"altitude\":0,\"speed\":0,\"x\":-20.394384243568318,\"y\":-3.593669430492326}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[{\"duration\":\"1\",\"time\":0,\"command\":\"Approach incident scene search ship containers and deploy to the incident area\"},{\"duration\":\"1\",\"time\":17,\"command\":\"Activation for casualty care purposes\"},{\"duration\":\"1\",\"time\":19,\"command\":\"End of exercise\"}]},{\"Image\":\"image for CBRN_Decontamination_1\",\"Name\":\"CBRN_Decontamination_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.611043223523303,\"latitude\":37.96432846703047,\"altitude\":0,\"speed\":0,\"x\":202.18107778083245,\"y\":40.13436660861305},{\"wayPoint\":1,\"timestep\":1,\"longitude\":23.610946941161313,\"latitude\":37.96432846703047,\"altitude\":0,\"speed\":0,\"x\":-10.718103509186575,\"y\":0},{\"wayPoint\":2,\"timestep\":19,\"longitude\":23.6106672638241,\"latitude\":37.96433763677923,\"altitude\":0,\"speed\":0,\"x\":-31.133538764761216,\"y\":0.9353191017828261}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[{\"duration\":\"1\",\"time\":0,\"command\":\"Approach incident scene search ship containers and deploy to the incident area \"},{\"duration\":\"1\",\"time\":1,\"command\":\"Establish Develop decontamination lines and equipment\"},{\"duration\":\"1\",\"time\":19,\"command\":\"End of exercise\"}]},{\"Image\":\"image for CBRN_Recce_1\",\"Name\":\"CBRN_Recce_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.61126687606516,\"latitude\":37.96406911382446,\"altitude\":0,\"speed\":0,\"x\":227.0779648547859,\"y\":13.679858746142235},{\"wayPoint\":1,\"timestep\":1,\"longitude\":23.611166153918326,\"latitude\":37.96405472494634,\"altitude\":0,\"speed\":0,\"x\":-11.21233809702881,\"y\":-1.467669405804064},{\"wayPoint\":2,\"timestep\":5,\"longitude\":23.61107622343008,\"latitude\":37.96405832216587,\"altitude\":0,\"speed\":0,\"x\":-10.011016158485173,\"y\":0.3669176335833283},{\"wayPoint\":3,\"timestep\":6,\"longitude\":23.610946723527007,\"latitude\":37.9640619193854,\"altitude\":0,\"speed\":0,\"x\":-14.415863267664967,\"y\":0.36691788532444464},{\"wayPoint\":4,\"timestep\":7,\"longitude\":23.610838806941114,\"latitude\":37.96402954440963,\"altitude\":0,\"speed\":0,\"x\":-12.013219389786721,\"y\":-3.302264229021063},{\"wayPoint\":5,\"timestep\":8,\"longitude\":23.61074527923334,\"latitude\":37.96403314162916,\"altitude\":0,\"speed\":0,\"x\":-10.411456804666386,\"y\":0.36691854991664846},{\"wayPoint\":6,\"timestep\":19,\"longitude\":23.6106805292818,\"latitude\":37.96403314162916,\"altitude\":0,\"speed\":0,\"x\":-7.207931634030228,\"y\":0}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[{\"duration\":\"1\",\"time\":0,\"command\":\"Approach incident scene search ship containers and deploy to the incident area\"},{\"duration\":\"1\",\"time\":5,\"command\":\"Approach the area and check the customs worker and the coast guards for possible decontamination\"},{\"duration\":\"1\",\"time\":6,\"command\":\"Enter the container to check for possible radiation\"},{\"duration\":\"1\",\"time\":7,\"command\":\"Element leader check the elements for possible decontamination\"},{\"duration\":\"1\",\"time\":8,\"command\":\"Proceed to decontamination line\"},{\"duration\":\"1\",\"time\":19,\"command\":\"End of exercise\"}]},{\"Image\":\"image for Endeavour2\",\"Name\":\"Endeavour2\",\"Type\":\"UGV\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":[\"pressure\"],\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":2,\"longitude\":23.61107574921495,\"latitude\":37.96420855989647,\"altitude\":31,\"speed\":14,\"x\":205.80182121273987,\"y\":27.903616628924535},{\"wayPoint\":1,\"timestep\":3,\"longitude\":23.610785694137807,\"latitude\":37.964224674067424,\"altitude\":31,\"speed\":14,\"x\":-32.288783489707406,\"y\":1.6436521315880637},{\"wayPoint\":2,\"timestep\":4,\"longitude\":23.610511753231613,\"latitude\":37.964160217383615,\"altitude\":31,\"speed\":14,\"x\":-30.49496218494338,\"y\":-6.574623074367628}],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]}]";
        String teloneioRealScript_1 = "{\"data\":[{\"location\":[{\"timestep\":0.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.611011292531142,37.96446638663171,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610804376403845,37.96461633804494,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61126687606516,37.96384968343314,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61124529274798,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61123722408472,37.963748918739434,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611043223523303,37.96432846703047,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61126687606516,37.96406911382446,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"0.0,0.0,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Approach_incident_scene_search_ship_containers_and_deploy_to_the_incident_area\",\"duration\":1}],[{\"command\":\"Approach_incident_scene_search_ship_containers_and_deploy_to_the_incident_area\",\"duration\":1}],[{\"command\":\"Approach_incident_scene_search_ship_containers_and_deploy_to_the_incident_area\",\"duration\":1}],[{\"command\":\"Approach_incident_scene_search_ship_containers_and_deploy_to_the_incident_area\",\"duration\":1}],[{\"command\":\"Approach_incident_scene_search_ship_containers_and_deploy_to_the_incident_area\",\"duration\":1}],[{\"command\":\"Approach_incident_scene_search_ship_containers_and_deploy_to_the_incident_area_\",\"duration\":1}],[{\"command\":\"Approach_incident_scene_search_ship_containers_and_deploy_to_the_incident_area\",\"duration\":1}],[]]}]},{\"location\":[{\"timestep\":1.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.611011292531142,37.96441804411885,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61061951300733,37.96464994957158,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611258851498516,37.96384857659636,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611233302016213,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611225203790035,37.96374601728899,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610946941161313,37.96432846703047,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611166153918326,37.96405472494634,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"11.805537874607476,18.982104279948235,15.5\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Establish_and_Develop_decontamination_lines_\",\"duration\":1}],[{\"command\":\"Establish_-_Develop_decontamination_lines_and_equipment_\",\"duration\":1}],[],[],[],[{\"command\":\"Establish_Develop_decontamination_lines_and_equipment\",\"duration\":1}],[],[]]}]},{\"location\":[{\"timestep\":2.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.611011292531142,37.96441804411885,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610367426557538,37.96468356109822,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611250826931872,37.963847469759585,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611221311284446,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611213183495348,37.96374311583855,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610931403531467,37.964328976460955,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611143671296265,37.964055624251216,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61107574921495,37.96420855989647,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":3.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.611011292531142,37.96441804411885,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6102497862143,37.964672357256006,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61124280236523,37.96384636292281,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61120932055268,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61120116320066,37.9637402143881,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61091586590162,37.96432948589144,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611121188674204,37.964056523556096,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610785694137807,37.964224674067424,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":4.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.611011292531142,37.96441804411885,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610137747792173,37.96460513420273,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611234777798586,37.96384525608603,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61119732982091,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611189142905975,37.96373731293766,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610900328271775,37.964329995321926,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611098706052143,37.964057422860975,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[],[],[],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":5.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610946835847333,37.96441804411885,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61003131129115,37.964588328439405,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611226753231943,37.963844149249255,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611185339089143,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611177122611288,37.963734411487216,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61088479064193,37.96433050475241,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61107622343008,37.96405832216587,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_1_Approach_the_area_and_check_the_customs_worker_and_the_coast_guards_for_possible_decontamination\",\"duration\":1}],[{\"command\":\"Recce_1_Approach_the_area_and_check_the_customs_worker_and_the_coast_guards_for_possible_decontamination\",\"duration\":1}],[],[],[],[],[{\"command\":\"Approach_the_area_and_check_the_customs_worker_and_the_coast_guards_for_possible_decontamination\",\"duration\":1}],[]]}]},{\"location\":[{\"timestep\":6.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610946835847333,37.96441804411885,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609863253657952,37.96456592075498,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6112187286653,37.96384304241248,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611173348357376,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6111651023166,37.96373151003677,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610869253012083,37.964331014182896,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610946723527007,37.9640619193854,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_1_Enter_the_container_to_check_for_possible_radiatio\",\"duration\":1}],[{\"command\":\"Recce_1_Enter_the_container_to_check_for_possible_radiation\",\"duration\":1}],[],[],[],[],[{\"command\":\"Enter_the_container_to_check_for_possible_radiation\",\"duration\":1}],[]]}]},{\"location\":[{\"timestep\":7.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610946835847333,37.96441804411885,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611210704098657,37.9638419355757,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61116135762561,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611153082021914,37.96372860858633,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610853715382238,37.96433152361338,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610838806941114,37.96402954440963,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_1_Element_leader_check_the_elements_for_possible_decontamination_\",\"duration\":1}],[{\"command\":\"Recce_1_Element_leader_check_the_elements_for_possible_decontamination\",\"duration\":1}],[],[],[],[],[{\"command\":\"Element_leader_check_the_elements_for_possible_decontamination\",\"duration\":1}],[]]}]},{\"location\":[{\"timestep\":8.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610914607505425,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611202679532013,37.963840828738924,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61114936689384,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611141061727228,37.963725707135886,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61083817775239,37.96433203304387,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61074527923334,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Recce_1_Proceed_to_decontamination_line_\",\"duration\":1}],[{\"command\":\"Recce_1_Proceed_to_decontamination_line\",\"duration\":1}],[],[],[],[],[{\"command\":\"Proceed_to_decontamination_line\",\"duration\":1}],[]]}]},{\"location\":[{\"timestep\":9.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.61088237916352,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61119465496537,37.96383972190215,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611137376162088,37.96391443338468,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61112904143254,37.96372280568544,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610822640122546,37.96433254247435,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61073939287411,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_2_Enter_the_container_to_remove_and_shield_the_source_\",\"duration\":1}],[{\"command\":\"Recce_2_Enter_the_container_to_remove_and_shield_the_source\",\"duration\":1}],[],[{\"command\":\"Enter_the_container_to_remove_and_shield_the_source\",\"duration\":1}],[],[],[],[]]}]},{\"location\":[{\"timestep\":10.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.61086626499257,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611186630398727,37.96383861506537,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61102945957619,37.96390004450656,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611117021137854,37.963719904235,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6108071024927,37.96433305190484,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61073350651488,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_2_Once_the_source_is_shielded_enter_the_container_for_further_check\",\"duration\":1}],[{\"command\":\"Recce_2__Once_the_source_is_shielded_enter_the_container_for_further_check\",\"duration\":1}],[],[{\"command\":\"Once_the_source_is_shielded_enter_the_container_for_further_check\",\"duration\":1}],[],[],[],[]]}]},{\"location\":[{\"timestep\":11.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610753465795902,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611178605832084,37.96383750822859,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61092514020983,37.96388565562844,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611105000843168,37.963717002784556,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610791564862854,37.96433356133532,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61072762015565,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Recce_2_Element_leader_check_the_elements_for_possible_decontamination\",\"duration\":1}],[{\"command\":\"Recce_2__Element_leader_check_the_elements_for_possible_decontamination\",\"duration\":1}],[],[{\"command\":\"Element_leader_check_the_elements_for_possible_decontamination\",\"duration\":1}],[],[],[],[]]}]},{\"location\":[{\"timestep\":12.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610656780770185,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61117058126544,37.963836401391816,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610835209721582,37.963882058408906,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61109298054848,37.96371410133411,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61077602723301,37.96433407076581,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61072173379642,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Recce_2_Proceed_to_decontamination_line\",\"duration\":1}],[{\"command\":\"Recce_2_Proceed_to_decontamination_line_\",\"duration\":1}],[],[{\"command\":\"Proceed_to_decontamination_line\",\"duration\":1}],[],[],[],[]]}]},{\"location\":[{\"timestep\":13.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610576209915422,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611162556698794,37.96383529455502,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610759668111456,37.96389644728703,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611080960253794,37.96371119988367,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610760489603162,37.964334580196294,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61071584743719,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_3__Enter_the_container_to_remove_and_isolate_the_second_source\",\"duration\":1}],[{\"command\":\"Recce_3_Enter_the_container_to_remove_and_isolate_the_second_source\",\"duration\":1}],[{\"command\":\"Enter_the_container_to_remove_and_isolate_the_second_source\",\"duration\":1}],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":14.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610576209915422,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611097806747257,37.96381371123784,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610748876452867,37.96389524821385,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611068939959107,37.963708298433225,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610744951973317,37.96433508962678,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610709961077962,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_3_Once_the_source_is_shielded_enter_the_container_for_further_check\",\"duration\":1}],[{\"command\":\"Recce_3_Once_the_source_is_shielded_enter_the_container_for_further_check\",\"duration\":1}],[{\"command\":\"Once_the_source_is_shielded_enter_the_container_for_further_check\",\"duration\":1}],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":15.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610576209915422,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61104744567384,37.96381371123784,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610738084794278,37.96389404914068,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61105691966442,37.96370539698278,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61072941434347,37.964335599057264,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610704074718733,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_3_Element_leader_check_the_elements__the_vehicle_and_the_safety_box_for_possible_decontamination_\",\"duration\":1}],[{\"command\":\"Recce_3_Element_leader_check_the_elements_the_vehicle_and_the_safety_box_for_possible_decontamination\",\"duration\":1}],[{\"command\":\"Element_leader_check_the_elements__the_vehicle_and_the_safety_box_for_possible_decontamination_\",\"duration\":1}],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":16.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610576209915422,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610957515185596,37.96380291957925,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61072729313569,37.9638928500675,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611044899369734,37.96370249553234,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610713876713625,37.96433610848775,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610698188359503,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"recce_3__Transport_the_shielded_sources_to_GAEC\",\"duration\":1}],[{\"command\":\"Transport_the_shielded_sources_to_GAEC_\",\"duration\":1}],[{\"command\":\"Transport_the_shielded_sources_to_GAEC\",\"duration\":1}],[],[],[],[],[]]}]},{\"location\":[{\"timestep\":17.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610576209915422,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610932334648886,37.9638005214329,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6107165014771,37.96389165099433,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.611032879075022,37.96369959408192,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61069833908378,37.964336617918235,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610692302000274,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"medical_Activation_for_casualty_care_purposes\",\"duration\":1}],[{\"command\":\"Medical_Activation_for_casualty_care_purposes\",\"duration\":1}],[],[],[{\"command\":\"Activation_for_casualty_care_purposes\",\"duration\":1}],[],[],[]]}]},{\"location\":[{\"timestep\":18.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610576209915422,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.609784826762464,37.96453230922834,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610907154112176,37.96379812328655,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61070570981851,37.96389045192115,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61094127613964,37.96368197813281,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610682801453933,37.96433712734872,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610686415641045,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"decontamination_Establish_incident_perimeter_if_needed\",\"duration\":1}],[{\"command\":\"Decontamination_Establish_incident_perimeter_if_needed\",\"duration\":1}],[],[{\"command\":\"Establish_incident_perimeter_if_needed\",\"duration\":1}],[],[],[],[]]}]},{\"location\":[{\"timestep\":19.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.610576209915422,37.964434158289805,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.60967381634208,37.96446638663171,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61088197357547,37.963795725140194,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610694918159922,37.96388925284797,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.61084967320426,37.9636643621837,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6106672638241,37.96433763677923,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.6106805292818,37.96403314162916,0.0\"},{\"nodeCommand\":\"goto\",\"node\":\"23.610511753231613,37.964160217383615,31.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"},{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"End_of_exercise\",\"duration\":1}],[{\"command\":\"End_of_exercise\",\"duration\":1}],[{\"command\":\"End_of_exercise\",\"duration\":1}],[{\"command\":\"End_of_exercise\",\"duration\":1}],[{\"command\":\"End_of_exercise\",\"duration\":1}],[{\"command\":\"End_of_exercise\",\"duration\":1}],[{\"command\":\"End_of_exercise\",\"duration\":1}],[]]}]}],\"nodeNames\":[{\"nodeName\":\"General_Officer_2\"},{\"nodeName\":\"General_Officer_1\"},{\"nodeName\":\"CBRN_Recce_3\"},{\"nodeName\":\"CBRN_Recce_2\"},{\"nodeName\":\"CBRN_Medical_1\"},{\"nodeName\":\"CBRN_Decontamination_1\"},{\"nodeName\":\"CBRN_Recce_1\"},{\"nodeName\":\"Endeavour2\"}],\"Area\":\"Telonio_Geofence_HMOD\"}";
      
        ddlScriptRepository.save(new DdlScript(null,"Telonio_22",null,"Telonio_22",teloneioRealScript_1,teloneioScript_1));
        //experimentRepository.save(new Experiment(3,"Telonio", null, "Telonio", "16.01", null, ddlScriptRepository.getOne(3), null, userRepository.getOne(1)));
        
        experimentRepository.save(new Experiment(4,"Telonio_22", null, "Telonio_22", "21.01", null, ddlScriptRepository.getOne(4), experimentStatusRepository.getOne(2), userRepository.getOne(1)));

        
        
        Reservation res7 = new Reservation(null,reservationStatusRepository.getOne(4), LocalDateTime.of(2021,6,22,8,10,0), LocalDateTime.of(2021,6,22,19,10,0), testbedAreaRepository.getOne(2), userRepository.getOne(1));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(11)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(12)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(13)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(14)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(15)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(16)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(17)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(21)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(22)));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res7, resourceRepository.findByResourceId(4)));

        reservationRepository.save(res7);

        experimentExecutionRepository.save(new ExperimentExecution(null,null,2,null,null,experimentRepository.getOne(4)));
        
        Reservation res8 = new Reservation(null,reservationStatusRepository.getOne(3), LocalDateTime.of(2021,9,13,8,10,0), LocalDateTime.of(2021,9,13,19,10,0), testbedAreaRepository.getOne(4), userRepository.getOne(1));
        res8.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res8, resourceRepository.findByResourceId(17)));
        res8.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res8, resourceRepository.findByResourceId(18)));
        res8.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res8, resourceRepository.findByResourceId(19)));
        res8.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res8, resourceRepository.findByResourceId(20)));
        res8.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res8, resourceRepository.findByResourceId(21)));
        res8.addReservationItem(new ReservationItem(null, experimentRepository.getOne(4), res8, resourceRepository.findByResourceId(22)));

        reservationRepository.save(res8);

    }
    
    
    @Autowired
	public InitialData(TestbedAreaRepository testbedAreaRepository, OperatorRepository operatorRepository, OperatorCategoryRepository operatorCategoryRepository,
			TestbedRepository testbedRepository, ReservationRepository reservationRepository,
			UxVRepository uxvRepository, UxVTypeRepository uxvTypeRepository, UxVSensorRepository uxvSensorRepository,
			ReservationStatusRepository reservationStatusRepository, ResourceTypeRepository resourceTypeRepository,
			UserRepository userRepository, ResourceRepository resourceRepository, SensorRepository sensorRepository,
			SensorTypeRepository sensorTypeRepository, ObstacleRepository obstacleRepository,ResourceSpecificationRepository resourceSpecificationRepository,   EquipmentRepository equipmentRepository,
			EquipmentTypeRepository equipmentTypeRepository,ExperimentStatusRepository experimentStatusRepository,ExperimentRepository experimentRepository, DdlScriptRepository ddlScriptRepository,
			ExperimentExecutionRepository experimentExecutionRepository) {
		super();
		this.testbedAreaRepository = testbedAreaRepository;
		this.operatorRepository = operatorRepository;
		this.operatorCategoryRepository = operatorCategoryRepository;
		this.testbedRepository = testbedRepository;
		this.reservationRepository = reservationRepository;
		this.uxvRepository = uxvRepository;
		this.uxvTypeRepository = uxvTypeRepository;
		this.uxvSensorRepository = uxvSensorRepository;
		this.reservationStatusRepository = reservationStatusRepository;
		this.resourceTypeRepository = resourceTypeRepository;
		this.userRepository = userRepository;
		this.resourceRepository = resourceRepository;
		this.sensorRepository = sensorRepository;
		this.sensorTypeRepository = sensorTypeRepository;
		this.obstacleRepository = obstacleRepository;
		this.resourceSpecificationRepository = resourceSpecificationRepository;
		this.equipmentRepository = equipmentRepository;
		this.equipmentTypeRepository = equipmentTypeRepository;
		this.experimentStatusRepository = experimentStatusRepository;
		this.experimentRepository = experimentRepository;
		this.ddlScriptRepository = ddlScriptRepository;
		this.experimentExecutionRepository = experimentExecutionRepository;
	}



}

