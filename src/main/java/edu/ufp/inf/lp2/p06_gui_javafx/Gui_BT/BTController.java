package edu.ufp.inf.lp2.p06_gui_javafx.Gui_BT;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ResourceBundle;

import edu.ufp.inf.lp2.p01_intro.Date;
import edu.ufp.inf.lp2.p07_brigadaTransito.*;


public class BTController implements Initializable {

    //Constants declaration for PATHS
    // NB: when running inside IDE, paths are relative to Project's root directory
    private static final String PATH_VEHICLES = "./data/vehicles.txt";
    private static final String FILE_DELIMITER = ";";
    private static final String PATH_BIN = "./data/data_bt.bin";

    //Attributes linking to bt.fxml UI components
    @FXML
    public TableView<Vehicle> vehiclesTable;
    public TableColumn<Vehicle, String> registrationCol;
    public TableColumn<Vehicle, String> brandCol;
    public TableColumn<Vehicle, String> modelCol;
    public TableColumn<Vehicle, Integer> cylindersCol;
    public TextField registrationField;
    public TextField brandField;
    public TextField modelField;
    public TextField cylindersField;
    public ComboBox<String> vehicleComboBox;
    public ComboBox<String> driversComboBox;
    public TableView<PenaltyFee> penaltiesTable;
    public TableColumn<PenaltyFee, String> driverCol;
    public TableColumn<PenaltyFee, String> vehicleCol;
    public TableColumn<PenaltyFee, Date> dateCol;
    public TableColumn<PenaltyFee, String> localCol;
    public TableColumn<PenaltyFee, String> motiveCol;

    private final TransitPolice transitePolice = new TransitPolice();

    /**
     * Inicialização GUI
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registrationCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("registration"));
        registrationCol.setCellFactory(TextFieldTableCell.forTableColumn());

        brandCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
        brandCol.setCellFactory(TextFieldTableCell.forTableColumn());

        modelCol.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("model"));
        modelCol.setCellFactory(TextFieldTableCell.forTableColumn());

        cylindersCol.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("cylinders"));
        cylindersCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        /*
        cylindersCol.setCellFactory(new Callback<TableColumn<Vehicle, Integer>, TableCell<Vehicle, Integer>>() {
            @Override
            public TableCell<Vehicle, Integer> call(TableColumn<Vehicle, Integer> col) {
                return new TableCell<Vehicle, Integer>() {
                    @Override
                    protected void updateItem(Integer cylinders, boolean empty) {
                        super.updateItem(cylinders, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(Integer.toString(cylinders));
                        }
                    }
                };
            }
        });
        */

        /*
        vehicleCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PenaltyFee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<PenaltyFee, String> cellDataFeatures) {
                if (cellDataFeatures.getValue() != null) {
                    return new SimpleStringProperty(cellDataFeatures.getValue().getDriver().getName() + " - " + cellDataFeatures.getValue().getDriver().getDriversLicense());
                } else {
                    return new SimpleStringProperty("<No Info>");
                }
            }
        });
        */
        vehicleCol.setCellValueFactory((cellData) -> {
            if (cellData.getValue() != null) {
                return new SimpleStringProperty(cellData.getValue().getDriver().getName() + " - " + cellData.getValue().getDriver().getDriverLicense());
            } else {
                return new SimpleStringProperty("<No Info>");
            }
        });

        vehiclesTable.getItems().addListener((ListChangeListener<? super Vehicle>) vehiclesChanges -> {
            System.out.println("ListChangeListener - vehiclesChanges = " + vehiclesChanges);
            ObservableList<? extends Vehicle> list = vehiclesChanges.getList();
            list.forEach(vehicle -> {
                System.out.println("added " + vehicle);
            });
        });
    }

    /**
     * Handler para acção do botão de abertura do ficheiro de texto, referente aos dados dos veículos.
     *
     * @param actionEvent
     */
    public void handleReadTxtFileAction(ActionEvent actionEvent) {
        ArrayList<Vehicle> vehicleArrayList = readVehiclesFromTxtFile(PATH_VEHICLES);
        //TODO...
        //Clear and add all vehicles to vehiclesTable

        //Update ComboBox

    }

    /**
     * Handler para leitura de dados dos veículos a partir de um ficheiro de texto.
     *
     * @return ArrayList<Vehicle>
     * @throws IOException
     */
    private static ArrayList<Vehicle> readVehiclesFromTxtFile(String path) {
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
        BufferedReader br = null;
        try {
            //Open input stream
            br = new BufferedReader(new FileReader(path));
            //TODO...

        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return vehicleArrayList;
    }

    /**
     * Método para inserção de novos veículos na vehicleComboBox (tab Penalties).
     *
     * @param vehicles
     */
    private void addVehiclesToComboBox(ArrayList<Vehicle> vehicles) {
        vehicleComboBox.getItems().clear();
        //TODO...
    }

    /**
     * Handler para acção do botão de armazenamento de dados dos veículos num ficheiro de texto.
     *
     * @param actionEvent
     */
    public void handleSaveTxtFileAction(ActionEvent actionEvent) {
        saveVehiclesToTxtFile(PATH_VEHICLES, vehiclesTable.getItems().listIterator());
    }

    /**
     * Método para efectuar o armazenamento dos dados dos veículos num ficheiro de texto.
     */
    private static void saveVehiclesToTxtFile(String path, ListIterator<Vehicle> listIt) {
        System.out.println("saveVehiclesToTxtFile(): save vehicles to txt...");
        //Try with resources...
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            //TODO..
            //Save header of file

            //Iterate over listIt and save vehicles into file

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * Handler para acção do botão de encerramento da aplicação.
     *
     * @param actionEvent
     */
    public void handleExitAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Handler para acção do botão Add, responsável pela inserção de um veiculo na vehiclesTable.
     *
     * @param actionEvent
     */
    public void handleAddVehicleAction(ActionEvent actionEvent) {
        //TODO...
        //Get vehicle info from GUI TextFields

        // Instantiate new vehicle

        //Add vehicle to table row

        //Create ArrayList from all vehicles inside vehiclesTable

        //Add all vehicles to GUI ComboBox

        //Clear GUI TextFields
        registrationField.setText("");
        brandField.setText("");
        modelField.setText("");
        cylindersField.setText("");
    }

    /**
     * Handler para acção do botão de abertura do ficheiro binário, referente aos dados dos veículos.
     *
     * @param actionEvent
     */
    public void handleReadFileAction(ActionEvent actionEvent) {
        ArrayList<Vehicle> vehicleArrayList = handleReadBinFileAction(PATH_BIN);
        //TODO...
        //Clear vehiclesTable and add vehicles read from file

        //Update ComboBox
    }

    /**
     * Método para leitura do ficheiro binário, no path indicado.
     */
    private static ArrayList<Vehicle> handleReadBinFileAction(String path) {
        ArrayList<Vehicle> vehicleArrayList = null;
        ObjectInputStream ois = null;
        try {
            //Open input stream
            ois = new ObjectInputStream(new FileInputStream(new File(path)));
            //TODO...
            //Read and cast ArrayList of vehicles from file
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return vehicleArrayList;
    }

    /**
     * Handler para acção do botão de armazenamento de dados dos veículos num ficheiro binário.
     *
     * @param actionEvent
     */
    public void handleSaveFileAction(ActionEvent actionEvent) {
        handleSaveBinFileAction(PATH_BIN, this.vehiclesTable.getItems().listIterator());
    }

    /**
     * Método para efectuar o armazenamento dos dados dos veículos num ficheiro binário.
     */
    private static void handleSaveBinFileAction(String path, ListIterator<Vehicle> listIt) {
        ObjectOutputStream oos = null;
        try {
            //Open output stream
            oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            //TODO...
            //Create ArrayList with all vehicles

            //Save to file

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Handler para acção de edição dos dados dos veículos na vehiclesTable.
     *
     * @param vehicleStringCellEditEvent
     */
    public void handleEditVehicleAction(TableColumn.CellEditEvent<Vehicle, Object> vehicleStringCellEditEvent) {
        int col = vehicleStringCellEditEvent.getTablePosition().getColumn();
        switch (col) {
            case 0:
                vehicleStringCellEditEvent.getRowValue().setRegistration((String) vehicleStringCellEditEvent.getNewValue());
                break;
            case 1:
                vehicleStringCellEditEvent.getRowValue().setBrand((String) vehicleStringCellEditEvent.getNewValue());
                break;
            case 2:
                vehicleStringCellEditEvent.getRowValue().setModel((String) vehicleStringCellEditEvent.getNewValue());
                break;
            case 3:
                //vehicleStringCellEditEvent.getRowValue().setCylinders(Integer.parseInt(vehicleStringCellEditEvent.getNewValue()));
                vehicleStringCellEditEvent.getRowValue().setCilinders((Integer) vehicleStringCellEditEvent.getNewValue());
                break;
        }
    }

    /**
     * Handler para acção de selecção do veículo na vehicleComboBox (tab Penalties).
     * Pesquisa se veículo seleccionado tem alguma multa inserida pela brigada de trânsito
     *
     * @param actionEvent
     */
    public void handleSelectVehicleAction(ActionEvent actionEvent) {
        penaltiesTable.getItems().clear();
        String vRegistration = vehicleComboBox.getValue();
        try {
            Vehicle v = transitePolice.searchVehicle(vRegistration);
            if (v != null) {
                penaltiesTable.getItems().addAll(transitePolice.allPenaltyFeesByVehicle(v));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handler para acção de selecção dos condutores na driversComboBox (tab Penalties).
     *
     * @param actionEvent
     */
    public void handleSelectDriverAction(ActionEvent actionEvent) {
        System.out.println("Not implemented yet! :(");
    }


    public void handleReadBinFileAction(ActionEvent actionEvent) {
    }

    public void handleSaveBinFileAction(ActionEvent actionEvent) {
    }

    /*public ArrayList<Driver> createDriversAndPenaltyFeesForEachVehicleTestingPurposesOnly(ArrayList<Vehicle> vehicleArrayList){
        ArrayList<Driver> driversArrayList = new ArrayList();
        try {
            int driverIndex = 1;
            for(Vehicle vehicle : vehicleArrayList) {
                //Create Driver
                Driver driver=new Driver("Driver"+driverIndex, "P-00"+driverIndex);
                driversArrayList.add(driver);

                //Create Dates
                Date d1=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/200"+driverIndex);
                Date d2=new SimpleDateFormat("dd/MM/yyyy").parse("02/02/200"+driverIndex);

                //Create PenaltyFees
                PenaltyFee severePenaltyFee=new SeverePenaltyFee(d1, SeverePenaltyFee.PARKING_VIOLATION, "Porto", driver, vehicle);
                PenaltyFee verySeverePenaltyFee=new VerySeverePenaltyFee(d2, VerySeverePenaltyFee.DRIVING_UNDER_INFLUENCE_ALCOHOL, "Porto", driver, vehicle);

                this.addPenaltyFee(severePenaltyFee);
                this.addPenaltyFee(verySeverePenaltyFee);

                driverIndex++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driversArrayList;
    }*/
}
