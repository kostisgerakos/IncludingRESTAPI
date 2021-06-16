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
        
        sensorRepository.save(new Sensor(null, "gamma_probe", null, null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(4), testbedAreaRepository.getOne(2), "Sensor_Name 2", null, "uS_h", sensorTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));

        operatorCategoryRepository.save(new OperatorCategory(1,"Firefighter"));
        operatorCategoryRepository.save(new OperatorCategory(2,"CBRN_Recce"));
        operatorCategoryRepository.save(new OperatorCategory(3,"CBRN_Sampling"));
        operatorCategoryRepository.save(new OperatorCategory(4,"CBRN_Marking"));
        operatorCategoryRepository.save(new OperatorCategory(5,"CBRN_Decontamination"));
        operatorCategoryRepository.save(new OperatorCategory(6,"Medical"));

        
        operatorRepository.save(new Operator(null, "operators1", null, null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(1), "OperatorName1", operatorCategoryRepository.getOne(1)));
        operatorRepository.save(new Operator(null, "operators2", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(1), "OperatorName2", operatorCategoryRepository.getOne(1)));
        operatorRepository.save(new Operator(null, "operators3", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(1), "OperatorName3", operatorCategoryRepository.getOne(1)));
        operatorRepository.save(new Operator(null, "operators4", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(1), "OperatorName4", operatorCategoryRepository.getOne(1)));
        operatorRepository.save(new Operator(null, "operators5", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(1),"OperatorName5", operatorCategoryRepository.getOne(1)));
        operatorRepository.save(new Operator(null, "operators6", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(1), "OperatorName6", operatorCategoryRepository.getOne(1)));
	
        operatorRepository.save(new Operator(null, "CBRN_Recce_1", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Recce_1", operatorCategoryRepository.getOne(2)));
        operatorRepository.save(new Operator(null, "CBRN_Sampling_1", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Sampling_1", operatorCategoryRepository.getOne(2)));
        operatorRepository.save(new Operator(null, "CBRN_Marking_1", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Marking_1", operatorCategoryRepository.getOne(3)));
        operatorRepository.save(new Operator(null, "CBRN_Decontamination_1", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Decontamination_1", operatorCategoryRepository.getOne(4)));
        operatorRepository.save(new Operator(null, "CBRN_Medical_1", null, null, null, null, true, true,null, null, null, resourceTypeRepository.getOne(3), testbedAreaRepository.getOne(2), "CBRN_Medical_1", operatorCategoryRepository.getOne(5)));

        
    	equipmentRepository.save(new Equipment(null, "Backpacks", null, null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(2), testbedAreaRepository.getOne(1),10,equipmentTypeRepository.getOne(1)));
    	equipmentRepository.save(new Equipment(null, "Heavy_Backpacks", null, "+38.019445,+23.659844", null, null, true, false, null, null, null, resourceTypeRepository.getOne(2), testbedAreaRepository.getOne(1),20,equipmentTypeRepository.getOne(2)));
        
        /*uxvRepository.save(new UxV(null, "UGV1", "wizzit1", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),"Pressure,Light,Touch",resourceSpecificationRepository.getOne(1)));
        uxvRepository.save(new UxV(null, "UGV2", "wizzit2", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),"Pressure,Light,Touch",resourceSpecificationRepository.getOne(1)));
    	uxvRepository.save(new UxV(null, "UGV3", "wizzit3", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),"Pressure,Light,Touch",resourceSpecificationRepository.getOne(1)));
        */
    	
    

    	
    	uxvRepository.save(new UxV(null, "UGV1", "wizzit1", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));
        uxvRepository.save(new UxV(null, "UGV2", "wizzit2", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));
     	uxvRepository.save(new UxV(null, "UGV3", "wizzit3", null, null, null, true, true, null, null, null, resourceTypeRepository.getOne(1), testbedAreaRepository.getOne(1), uxvTypeRepository.getOne(2),resourceSpecificationRepository.getOne(1)));
        
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
        
        experimentExecutionRepository.save(new ExperimentExecution(1,null,2,null,null,experimentRepository.getOne(2)));
        
        String teloneioScript = "[{\"MetaInfo\":[{\"Username\":\"test\",\"Date\":\"20-06-2021\",\"selectedTime\":\"15:00\",\"startTime\":\"15:00\",\"endTime\":\"15:55\",\"Version\":\"0.02\",\"TestBedArea\":\"Haidari_Geofence_Area\",\"Longitude\":\"+38.017445\",\"Latitude\":\"+23.657844\",\"Polygon\":\"((23.653716133580634, 38.018219649282436),(23.655497120366523, 38.0144667154302), (23.658243702397773, 38.01424694307741),(23.66176276062531 ,38.0146695816325), (23.662706898198554, 38.01565009369502),(23.66429476593537, 38.0157515252287), (23.665131615148017, 38.01656297244477),(23.665195988164374, 38.017442030124194),(23.666247414098212, 38.018101316464524),(23.667899654851386, 38.01842250509719),(23.66957335327668, 38.01842250509719), (23.670345829472968, 38.018692978643436),(23.670388744817206, 38.019402966952974),(23.669122742162177, 38.02190477569502),(23.66826443527741, 38.02276686567676), (23.668010703392028, 38.02317112958378),(23.663397303886413, 38.022528792535724),(23.661787978477477,38.021269457508424), (23.65893410808563, 38.02168360363061), (23.653716133580634, 38.018219649282436))\",\"Obstacles\":[\"((23.6597691,38.02049484),(23.65922981,38.01935473),(23.66046005,38.01858941),(23.66113239,38.02025595),(23.6597591,38.02048484))\",\"((23.66445833,38.01798144),(23.66218381,38.01756659),(23.66314941,38.01896134),(23.66445833,38.01798144))\"],\"type\":\"outdoor\"}]},{\"Image\":\"image for sensor1\",\"Name\":\"sensor1\",\"Type\":\"StaticSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":null,\"MaxSpeed\":null,\"Speed\":null,\"MinAltitude\":null,\"MaxAltitude\":null,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.657844,\"latitude\":38.017445,\"altitude\":0,\"speed\":0}],\"WPs\":null,\"borrowed\":true,\"location\":[{\"altitude\":0,\"latitude\":38.017445,\"longitude\":23.657844,\"speed\":0,\"timestep\":0,\"wayPoint\":0}],\"definedTasksList\":[]},{\"Image\":\"image for sensor3\",\"Name\":\"sensor3\",\"Type\":\"StaticSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":null,\"MaxSpeed\":null,\"Speed\":null,\"MinAltitude\":null,\"MaxAltitude\":null,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.658844,\"latitude\":38.018445,\"altitude\":0,\"speed\":0}],\"WPs\":null,\"borrowed\":true,\"location\":[{\"altitude\":0,\"latitude\":38.018445,\"longitude\":23.658844,\"speed\":0,\"timestep\":0,\"wayPoint\":0}],\"definedTasksList\":[]},{\"Image\":\"image for sensor2\",\"Name\":\"sensor2\",\"Type\":\"MobileSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":false,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for gamma_probe\",\"Name\":\"gamma_probe\",\"Type\":\"MobileSensor\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators1\",\"Name\":\"operators1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators2\",\"Name\":\"operators2\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators3\",\"Name\":\"operators3\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators4\",\"Name\":\"operators4\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators5\",\"Name\":\"operators5\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for operators6\",\"Name\":\"operators6\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Recce_1\",\"Name\":\"CBRN_Recce_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Sampling_1\",\"Name\":\"CBRN_Sampling_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Marking_1\",\"Name\":\"CBRN_Marking_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for CBRN_Decontamination_1\",\"Name\":\"CBRN_Decontamination_1\",\"Type\":\"Operator\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for Heavy_Backpacks\",\"Name\":\"Heavy_Backpacks\",\"Type\":\"Equipment\",\"Status\":null,\"Selected\":null,\"MinSpeed\":0,\"MaxSpeed\":1,\"Speed\":0,\"MinAltitude\":0,\"MaxAltitude\":1,\"Altitude\":0,\"availableSensors\":null,\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[{\"wayPoint\":0,\"timestep\":0,\"longitude\":23.659844,\"latitude\":38.019445,\"altitude\":0,\"speed\":0}],\"WPs\":null,\"borrowed\":true,\"location\":[{\"altitude\":0,\"latitude\":38.019445,\"longitude\":23.659844,\"speed\":0,\"timestep\":0,\"wayPoint\":0}],\"definedTasksList\":[]},{\"Image\":\"image for UGV1\",\"Name\":\"UGV1\",\"Type\":\"UGV\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":[\"pressure\",\"light\"],\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]},{\"Image\":\"image for UGV2\",\"Name\":\"UGV2\",\"Type\":\"UGV\",\"Status\":null,\"Selected\":null,\"MinSpeed\":14,\"MaxSpeed\":55,\"Speed\":null,\"MinAltitude\":31,\"MaxAltitude\":65,\"Altitude\":null,\"availableSensors\":[\"pressure\"],\"availableAlgorithms\":null,\"availableCommunications\":null,\"definedSensorsList\":[],\"definedAlgorithmsList\":[],\"definedCommunicationsList\":[],\"definedEventsList\":null,\"definedWayPoints\":[],\"WPs\":null,\"borrowed\":true,\"location\":null,\"definedTasksList\":[]}]";
        String teloneioRealScript = "{\"data\":[{\"location\":[{\"timestep\":0.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.60973042192286,37.96298969952904,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Approach_incident_scene_search_ship_containers_and_secure_scene\",\"duration\":1}]]}]},{\"location\":[{\"timestep\":1.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.609976967714136,37.96294802981784,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Develop_decontamination_lines\",\"duration\":1}]]}]},{\"location\":[{\"timestep\":2.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.61019920617388,37.96294802981784,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[]]}]},{\"location\":[{\"timestep\":3.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.61039366482616,37.96307998390331,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Approach_the_container\",\"duration\":1}]]}]},{\"location\":[{\"timestep\":4.0},{\"nodes\":[{\"nodeCommand\":\"goto\",\"node\":\"23.6105325638635,37.96303136924024,0.0\"}],\"sensors\":[{\"sensorsActDeact\":\"\"}],\"tasks\":[[{\"command\":\"Enter_the_container_for_further_check\",\"duration\":1}]]}]}],\"nodeNames\":[{\"nodeName\":\"CBRN_Recce_1\"}],\"Area\":\"Telonio_Geofence_HMOD\"}";
      
        ddlScriptRepository.save(new DdlScript(null,"Telonio",null,"Telonio",teloneioRealScript,teloneioScript));
        //experimentRepository.save(new Experiment(3,"Telonio", null, "Telonio", "16.01", null, ddlScriptRepository.getOne(3), null, userRepository.getOne(1)));
        
        experimentRepository.save(new Experiment(3,"Telonio", null, "Telonio", "16.01", null, ddlScriptRepository.getOne(3), experimentStatusRepository.getOne(2), userRepository.getOne(1)));

        Reservation res7 = new Reservation(null,reservationStatusRepository.getOne(4), LocalDateTime.of(2021,6,16,17,35,0), LocalDateTime.of(2021,6,16,19,10,0), testbedAreaRepository.getOne(2), userRepository.getOne(1));
        res7.addReservationItem(new ReservationItem(null, experimentRepository.getOne(3), res7, resourceRepository.findByResourceId(11)));
        reservationRepository.save(res7);

        experimentExecutionRepository.save(new ExperimentExecution(null,null,2,null,null,experimentRepository.getOne(3)));

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

