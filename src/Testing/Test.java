package Testing;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.app.utility.IFileManager;
import com.app.utility.ImageManager;

public class Test implements IFileManager {
	public static void main(String[] args) {
		/*Vehicle vehicle1 = new Vehicle("Accord");

		Vehicle vehicle2 = new Vehicle("Civic");

		Vehicle vehicle3 = new Vehicle("CRV");
		
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(vehicle1);
		vehicles.add(vehicle2);
		vehicles.add(vehicle3);
		vehicles.forEach(v -> System.out.println(v.getVin()));
		for (Vehicle car : vehicles) {
			if (car.getVin().equals(vehicle3.getVin())) {
				System.out.println("match!");
			}
		}*/
		File file = new File("C:\\Claim Academy Workspace\\Workspace2\\AsianImports\\WebContent\\images\\2016_toyota_corolla-pic-3140676701361627438-1024x768.jpeg");


			try {
				byte[] imageBytes = ImageManager.toBytes(file);
				String image;
				image = ImageManager.toBase64(imageBytes);
				System.out.println(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
