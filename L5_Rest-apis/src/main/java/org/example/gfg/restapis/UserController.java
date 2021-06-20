package org.example.gfg.restapis;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Controller
@ResponseBody
public class UserController {

    RestTemplate restTemplate = new RestTemplate();

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    // RestController - Controller + ResponseBody

    // Client - ios / android / web application / postman / command line etc.

    // id -> user
    public HashMap<Integer, User> userMap = new HashMap<Integer, User>();

    @GetMapping("/users")
    public Map<Integer, User> getUsers(){
        return userMap;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") int id){
        return userMap.get(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        userMap.put(user.getId(), user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user){

        if(!userMap.containsKey(user.getId())){
            return;
        }

        userMap.put(user.getId(), user);
    }

    @DeleteMapping("/user/{user_id}")
    public User deleteUserById(@PathVariable("user_id") int id){
        return userMap.remove(id);
    }

  @PostMapping(value = "/parse")
  public void parseFile(HttpServletRequest request) throws IOException, ServletException {

    Part file = request.getPart("user_file");
    Part test = request.getPart("test_data");


    Part xlsFile = request.getPart("xls_file");

    InputStream xlsInputStream = xlsFile.getInputStream();

    logger.info("test data is {}", test.getName());

    CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");

    InputStream inputStream = file.getInputStream();

    CSVParser csvParser =
        new CSVParser(new InputStreamReader(inputStream, StandardCharsets.UTF_8), csvFormat);

    List<CSVRecord> records = csvParser.getRecords();

    IntStream.range(1, records.size())
        .forEach(
            i -> {
              CSVRecord record = records.get(i);
              User user =
                  User.builder()
                      .id(Integer.parseInt(record.get(0)))
                      .name(record.get(1))
                      .age(Integer.parseInt(record.get(2)))
                      .country(record.get(3))
                      .phone(
                          PhoneImpl.builder()
                              .number(Integer.parseInt(record.get(4)))
                              .countryCode(record.get(5))
                              .build())
                      .build();

              userMap.put(user.getId(), user);
            });
  }

  @GetMapping(value = "/user_image", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] getImage(@RequestParam("id") int id) {
        return restTemplate.getForObject("https://picsum.photos/id/" + id + "/200/300", byte[].class);
  }
}
