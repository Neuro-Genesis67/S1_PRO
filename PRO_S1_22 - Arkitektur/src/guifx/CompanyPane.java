package guifx;

import java.util.Optional;

import application.model.Company;
import application.model.Customer;
import application.model.Employee;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CompanyPane extends GridPane {
	private TextField txfName, txfHours;
	private TextArea txaEmps, txaCustomers;
	private ListView<Company> lvwCompanies;

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwCompanies = new ListView<>();
		this.add(lvwCompanies, 0, 1, 1, 3);
		lvwCompanies.setPrefWidth(200);
		lvwCompanies.setPrefHeight(200);
		lvwCompanies.getItems().setAll(Service.getCompanies());

		ChangeListener<Company> listener = (ov, oldCompny, newCompany) -> this.selectedCompanyChanged();
		lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		Label lblHours = new Label("Weekly Hours:");
		this.add(lblHours, 1, 2);

		txfHours = new TextField();
		this.add(txfHours, 2, 2);
		txfHours.setEditable(false);

		Label lblEmps = new Label("Employees:");
		this.add(lblEmps, 1, 3);
		GridPane.setValignment(lblEmps, VPos.BASELINE);
		lblEmps.setPadding(new Insets(4, 0, 4, 0));

		txaEmps = new TextArea();
		this.add(txaEmps, 2, 3);
		txaEmps.setPrefWidth(200);
		txaEmps.setPrefHeight(100);
		txaEmps.setEditable(false);

		Label lblCustomers = new Label("Customers: ");
		this.add(lblCustomers, 1, 4);

		txaCustomers = new TextArea();
		this.add(txaCustomers, 2, 4);

		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 5, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		Button btnAddCustomer = new Button("Add customer");
		hbxButtons.getChildren().add(btnAddCustomer);
		btnAddCustomer.setOnAction(e -> this.addCustomerAction());

		if (lvwCompanies.getItems().size() > 0) {
			lvwCompanies.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void addCustomerAction() {
		Dialog<String> dialog = new TextInputDialog();
		dialog.setTitle("Create new customer");
		dialog.setHeaderText("Input customer name: ");
		Optional<String> result = dialog.showAndWait();

		String input = "";
		if (result.isPresent()) { // If ok button is pushed
			input = result.get();
		}
		if (input.length() > 0) {

			Customer customer = Service.createCustomer(input);
			Company company = lvwCompanies.getSelectionModel().getSelectedItem();
			Service.connectCustomerToCompany(customer, company);
			txaCustomers.setText(txaCustomers.getText() + customer + "\n");
		}

		// Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		// Service.createCustomer(name, company);
	}

	private void createAction() {
		CompanyWindow dia = new CompanyWindow("Create Company");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwCompanies.getItems().setAll(Service.getCompanies());
		int index = lvwCompanies.getItems().size() - 1;
		lvwCompanies.getSelectionModel().select(index);
	}

	private void updateAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company == null)
			return;

		CompanyWindow dia = new CompanyWindow("Update Company", company);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
		lvwCompanies.getItems().setAll(Service.getCompanies());
		lvwCompanies.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company == null)
			return;

		if (company.employeesCount() == 0) {
			Stage owner = (Stage) this.getScene().getWindow();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Company");
			alert.initOwner(owner);
			alert.setHeaderText("Are you sure?");

			// Wait for the modal dialog to close
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				Service.deleteCompany(company);
				lvwCompanies.getItems().setAll(Service.getCompanies());
				this.updateControls();
			}
		} else {
			Stage owner = (Stage) this.getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Delete Company");
			alert.setHeaderText("Can't delete a company that has employees");
			alert.initOwner(owner);
			alert.showAndWait();
		}

	}

	// -------------------------------------------------------------------------

	private void selectedCompanyChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			txfName.setText(company.getName());
			txfHours.setText("" + company.getHours());
			StringBuilder sbEmp = new StringBuilder();
			for (Employee emp : company.getEmployees()) {
				sbEmp.append(emp + "\n");
			}
			txaEmps.setText(sbEmp.toString());
			StringBuilder sbCus = new StringBuilder();
			for (Customer cus : company.getCustomers()) {
				sbCus.append(cus + "\n");
			}
			txaCustomers.setText(sbCus.toString());
		} else {
			txfName.clear();
			txfHours.clear();
			txaEmps.clear();
		}
	}

}
