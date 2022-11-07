package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.model.Parking;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        String id1 = getUUID();
        String id2 = getUUID();
        String id3 = getUUID();
        String id4 = getUUID();
        Parking parking1 = new Parking(id1,"ADE-4257", "SC", "CELTA", "PRETO");
        Parking parking2 = new Parking(id2,"SGF-6418", "SP", "GOL", "BRANCO");
        Parking parking3 = new Parking(id3,"KNJ-3461", "RJ", "PALIO", "PRATA");
        Parking parking4 = new Parking(id4,"AFG-4156", "MG", "UNO", "VERMELHO");
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);
        parkingMap.put(id3, parking3);
        parkingMap.put(id4, parking4);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();

        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);

        return parkingCreate;
    }
}
