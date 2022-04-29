package com.payment.payfareserver;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PayFareServerApplicationTests {
//    @Autowired
//    ClientService clientService;
//    @Autowired
//    UserService userService;
//    @Autowired
//    TypeService typeService;
//
//    @Test
//    void contextLoads() {
//    }

  /*  @Test
    void addClient() {
        ClientDTO clientDTO = new ClientDTO();
        UserDTO userDTO = new UserDTO();
        TypeDTO typeDTO = new TypeDTO();
        User user = new User();
        Type type = new Type();
        Client client = new Client();
        typeDTO.setId(1);
        userDTO.setType(typeDTO);
        userDTO.setName("Moustafa Ibrahim");
        userDTO.setUserName("Moustafa");
        userDTO.setPassword("102030");
        userDTO.setPhone("01067893079");
        clientDTO.setUser(userDTO);
        clientDTO.setWallet(BigDecimal.valueOf(0.00d));
        user.setName(clientDTO.getUser().getName());
        user.setUserName(clientDTO.getUser().getUserName());
        user.setPassword(clientDTO.getUser().getPassword());
        user.setPhone(clientDTO.getUser().getPhone());
        user.setType(typeService.getTypeById(clientDTO.getUser().getType().getId()));
        client.setUser(userService.save(user));
        client.setWallet(clientDTO.getWallet());
        client = clientService.save(client);
        System.out.println(client);
    }*/

//    @Test
//    void getAllUserByTypeId(){
//        List<User> users = userService.getUsersByTypeId(3);
//        System.out.println(users);
//    }
}
