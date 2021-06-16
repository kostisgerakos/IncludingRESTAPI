package gr.uoa.di.pcomp.IncludingRESTAPI.views;

public interface View {
	public static interface ResourceView {
		public static interface Resource {
		}
		public static interface ResourceId {
		}
		public static interface ResourceIdTestbedId {
		}
		public static interface Sensor {
		}
		public static interface Operator {
		}
		public static interface UxV {
		}
		public static interface Equipment {
		}
	}
	public static interface ReservationView {
		public static interface ReservedResources {
		}
	}
	public static interface TestbedView {
		public static interface TestbedLocation {
		}
	}
	public static interface TestbedAreaView {
		public static interface TestbedAreaIsIndoor {
		}
		public static interface TestbedAreaObstacles {
		}
		public static interface TestbedAreaPolygonAndId {
		}
		///////////////To GO///////////////////
		public static interface TestbedAreaLocation {
		}
	}
	public static interface UserView {
		public static interface Username {
		}
	}
}
