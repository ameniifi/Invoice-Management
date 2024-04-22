
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InvoiceManagementApp extends JFrame {
    private List<Client> clients;
    private List<Credit> credits;
    private List<Product> products;
    private List<Invoice> invoices;
    private List<Vendor> vendors;
    private DefaultListModel<String> clientListModel;
    private DefaultListModel<String> creditListModel;
    private DefaultListModel<String> productListModel;
    private DefaultListModel<String> invoiceListModel;
    private DefaultListModel<String> vendorListModel;
    private JList<String> clientList;
    private JList<String> creditList;
    private JList<String> productList;
    private JList<String> invoiceList;
    private JList<String> vendorList;
    private JTextArea clientDescriptionArea;
    private JTextArea vendorDescriptionArea;
    private JTextArea creditDescriptionArea;
    private JTextArea productDetailsArea;
    private JTextField clientNameField;
    private JTextField vendorNameField;
    private JTextField creditNameField;
    private JTextField productNameField;
    private JTextField productDescriptionField;
    private JTextField productCategoryField;
    private JTextField productDefaultQuantityField;
    private JTextField productMaxQuantityField;
    private JTextField invoiceNumberField;
    private JTextField invoiceClientField;
    private JTextField invoiceDateField;

    // edit client dialog
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField addressField;
    private JTextField shippingAddressField;
    private JTextField phoneNumberField;
    private JTextField emailAddressField;


    // edit vendor dialog
    private JTextField firstNamevField;
    private JTextField lastNamevField;
    private JTextField addressvField;
    private JTextField shippingAddressvField;
    private JTextField phoneNumbervField;
    private JTextField emailAddressvField;



/*
    private JTextField clientFirstNameField;
    private JTextField clientLastNameField;
    private JTextField clientEmailField;
    private JTextField clientPhoneField;
    private JTextField clientBillingAddressField;
    private JTextField clientShippingAddressField;
    private JButton createClientButton;
    private JButton editClientButton;
    private JButton deleteClientButton;

 */





    private JTextField invoiceDueDateField;
    private JTextArea invoiceTotalArea;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JTable productTable;
    private DefaultTableModel invoiceTableModel;

    public InvoiceManagementApp() {
        setTitle("Invoice Management App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JButton clientsButton = new JButton("Clients");
        JButton creditsButton = new JButton("Credits");
        JButton productsButton = new JButton("Products");
        JButton invoicesButton = new JButton("Invoices");
        JButton paymentsButton = new JButton("Payments");
        JButton projectsButton = new JButton("Projects");
        JButton tasksButton = new JButton("Tasks");
        JButton vendorsButton = new JButton("Vendors");
        JButton purchaseordersButton = new JButton("Purchase orders");
        JButton expensesButton = new JButton("Expenses");
        JButton settingsButton = new JButton("Settings");

        topPanel.add(clientsButton);
        topPanel.add(creditsButton);
        topPanel.add(productsButton);
        topPanel.add(invoicesButton);
        topPanel.add(paymentsButton);
        topPanel.add(projectsButton);
        topPanel.add(tasksButton);
        topPanel.add(vendorsButton);
        topPanel.add(purchaseordersButton);
        topPanel.add(expensesButton);
        topPanel.add(settingsButton);

        add(topPanel, BorderLayout.NORTH);

        // Main Panel with CardLayout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Client Panel
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BorderLayout());

        // Left Panel (Client List)
        JPanel clientListPanel = new JPanel();
        clientListPanel.setLayout(new BorderLayout());

        clientListModel = new DefaultListModel<>();
        clientList = new JList<>(clientListModel);

        JScrollPane clientScrollPane = new JScrollPane(clientList);

        clientListPanel.add(clientScrollPane, BorderLayout.CENTER);

        // Right Panel (Client Details)
        JPanel clientDetailsPanel = new JPanel();
        clientDetailsPanel.setLayout(new BorderLayout());

        clientNameField = new JTextField(20);
        JButton createClientButton = new JButton("Create Client");

        JPanel clientFormPanel = new JPanel();
        clientFormPanel.add(new JLabel("Client Name: "));
        clientFormPanel.add(clientNameField);
        clientFormPanel.add(createClientButton);

        clientDescriptionArea = new JTextArea(10, 30);
        clientDescriptionArea.setEditable(false);

        clientDetailsPanel.add(clientFormPanel, BorderLayout.NORTH);
        clientDetailsPanel.add(new JScrollPane(clientDescriptionArea), BorderLayout.CENTER);

        clientPanel.add(clientListPanel, BorderLayout.WEST);
        clientPanel.add(clientDetailsPanel, BorderLayout.CENTER);












     // Edit Client Button
     JButton editClientButton = new JButton("Edit Client");
     clientDetailsPanel.add(editClientButton, BorderLayout.SOUTH);

     editClientButton.addActionListener(e -> {
         int selectedIndex = clientList.getSelectedIndex();
         if (selectedIndex != -1) {
             Client selectedClient = clients.get(selectedIndex);
             showEditClientDialog(selectedClient);
         }
     });



   








        // Credit Panel
        JPanel creditPanel = new JPanel();
        creditPanel.setLayout(new BorderLayout());

        // Left Panel (Credit List)
        JPanel creditListPanel = new JPanel();
        creditListPanel.setLayout(new BorderLayout());

        creditListModel = new DefaultListModel<>();
        creditList = new JList<>(creditListModel);

        JScrollPane creditScrollPane = new JScrollPane(creditList);

        creditListPanel.add(creditScrollPane, BorderLayout.CENTER);

        // Right Panel (Credit Details)
        JPanel creditDetailsPanel = new JPanel();
        creditDetailsPanel.setLayout(new BorderLayout());

        creditNameField = new JTextField(20);
        JButton createCreditButton = new JButton("Create Credit");

        JPanel creditFormPanel = new JPanel();
        creditFormPanel.add(new JLabel("Credit Name: "));
        creditFormPanel.add(creditNameField);
        creditFormPanel.add(createCreditButton);

        creditDescriptionArea = new JTextArea(10, 30);
        creditDescriptionArea.setEditable(false);

        creditDetailsPanel.add(creditFormPanel, BorderLayout.NORTH);
        creditDetailsPanel.add(new JScrollPane(creditDescriptionArea), BorderLayout.CENTER);

        creditPanel.add(creditListPanel, BorderLayout.WEST);
        creditPanel.add(creditDetailsPanel, BorderLayout.CENTER);




 // Edit CREDIT Button
     JButton editCreditButton = new JButton("Edit Credit");
     creditDetailsPanel.add(editCreditButton, BorderLayout.SOUTH);

     editCreditButton.addActionListener(e -> {
         int selectedIndex = creditList.getSelectedIndex();
         if (selectedIndex != -1) {
             Credit selectedCredit = credits.get(selectedIndex);
             showEditCreditDialog(selectedCredit);
         }
     });



     






        // Product Panel
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BorderLayout());

        // Left Panel (Product List)
        JPanel productListPanel = new JPanel();
        productListPanel.setLayout(new BorderLayout());

        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);

        JScrollPane productScrollPane = new JScrollPane(productList);

        productListPanel.add(productScrollPane, BorderLayout.CENTER);

        // Right Panel (Product Details)
        JPanel productDetailsPanel = new JPanel();
        productDetailsPanel.setLayout(new BorderLayout());

        JPanel productFormPanel = new JPanel();
        productFormPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Product Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        productFormPanel.add(new JLabel("Product Name: "), gbc);

        productNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        productFormPanel.add(productNameField, gbc);

        // Add Product Button
        gbc.gridx = 2;
        gbc.gridy = 0;
        JButton addProductButton = new JButton("Add Product");
        productFormPanel.add(addProductButton, gbc);

        // Product Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        productFormPanel.add(new JLabel("Description: "), gbc);

        productDescriptionField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        productFormPanel.add(productDescriptionField, gbc);

        // Product Category
        gbc.gridx = 0;
        gbc.gridy = 2;
        productFormPanel.add(new JLabel("Category: "), gbc);

        productCategoryField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        productFormPanel.add(productCategoryField, gbc);

        // Product Default Quantity
        gbc.gridx = 0;
        gbc.gridy = 3;
        productFormPanel.add(new JLabel("Default Quantity: "), gbc);

        productDefaultQuantityField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        productFormPanel.add(productDefaultQuantityField, gbc);

        // Product Max Quantity
        gbc.gridx = 0;
        gbc.gridy = 4;
        productFormPanel.add(new JLabel("Max Quantity: "), gbc);

        productMaxQuantityField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        productFormPanel.add(productMaxQuantityField, gbc);

        // Add Form Panel to Details Panel
        productDetailsPanel.add(productFormPanel, BorderLayout.NORTH);

        // Edit Product Button
        JButton editProductButton = new JButton("Edit Product");
        productDetailsPanel.add(editProductButton, BorderLayout.SOUTH);

        addProductButton.addActionListener(e -> {
            String productName = productNameField.getText();
            String productDescription = productDescriptionField.getText();
            if (!productName.isEmpty()) {
                Product product = new Product(productName, productDescription);
                products.add(product);
                productListModel.addElement(product.getName());
                productNameField.setText("");
                productDescriptionField.setText("");
            }
        });

        // Edit Product Button
        editProductButton.addActionListener(e -> {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                Product selectedProduct = products.get(selectedIndex);
                String description = productDescriptionField.getText();
                String category = productCategoryField.getText();
                int defaultQuantity = Integer.parseInt(productDefaultQuantityField.getText());
                int maxQuantity = Integer.parseInt(productMaxQuantityField.getText());

                selectedProduct.setDescription(description);
                selectedProduct.setCategory(category);
                selectedProduct.setDefaultQuantity(defaultQuantity);
                selectedProduct.setMaxQuantity(maxQuantity);
            }
        });

        // Product Details Area
        productDetailsArea = new JTextArea(10, 30);
        productDetailsArea.setEditable(false);

        productDetailsPanel.add(new JScrollPane(productDetailsArea), BorderLayout.CENTER);

        productPanel.add(productListPanel, BorderLayout.WEST);
        productPanel.add(productDetailsPanel, BorderLayout.CENTER);

        // Invoice Panel
        JPanel invoicePanel = new JPanel();
        invoicePanel.setLayout(new BorderLayout());

        // Left Panel (Invoice List)
        JPanel invoiceListPanel = new JPanel();
        invoiceListPanel.setLayout(new BorderLayout());

        invoiceListModel = new DefaultListModel<>();
        invoiceList = new JList<>(invoiceListModel);

        JScrollPane invoiceScrollPane = new JScrollPane(invoiceList);

        invoiceListPanel.add(invoiceScrollPane, BorderLayout.CENTER);

        // Right Panel (Invoice Details)
        JPanel invoiceDetailsPanel = new JPanel();
        invoiceDetailsPanel.setLayout(new BorderLayout());

        JPanel invoiceFormPanel = new JPanel();
        invoiceFormPanel.setLayout(new GridBagLayout());
        GridBagConstraints invoiceGbc = new GridBagConstraints();
        invoiceGbc.anchor = GridBagConstraints.WEST;
        invoiceGbc.insets = new Insets(5, 5, 5, 5);

        // Invoice Number
        invoiceGbc.gridx = 0;
        invoiceGbc.gridy = 0;
        invoiceFormPanel.add(new JLabel("Invoice Number: "), invoiceGbc);

        invoiceNumberField = new JTextField(20);
        invoiceGbc.gridx = 1;
        invoiceGbc.gridy = 0;
        invoiceFormPanel.add(invoiceNumberField, invoiceGbc);

        // Invoice Client
        invoiceGbc.gridx = 0;
        invoiceGbc.gridy = 1;
        invoiceFormPanel.add(new JLabel("Client: "), invoiceGbc);

        invoiceClientField = new JTextField(20);
        invoiceGbc.gridx = 1;
        invoiceGbc.gridy = 1;
        invoiceFormPanel.add(invoiceClientField, invoiceGbc);

        // Invoice Date
        invoiceGbc.gridx = 0;
        invoiceGbc.gridy = 2;
        invoiceFormPanel.add(new JLabel("Invoice Date: "), invoiceGbc);

        invoiceDateField = new JTextField(20);
        invoiceGbc.gridx = 1;
        invoiceGbc.gridy = 2;
        invoiceFormPanel.add(invoiceDateField, invoiceGbc);

        // Invoice Due Date
        invoiceGbc.gridx = 0;
        invoiceGbc.gridy = 3;
        invoiceFormPanel.add(new JLabel("Due Date: "), invoiceGbc);

        invoiceDueDateField = new JTextField(20);
        invoiceGbc.gridx = 1;
        invoiceGbc.gridy = 3;
        invoiceFormPanel.add(invoiceDueDateField, invoiceGbc);

        // Invoice Product Table
        invoiceTableModel = new DefaultTableModel(new Object[]{"Product", "Quantity", "Unit Price", "Total"}, 0);
        productTable = new JTable(invoiceTableModel);
        JScrollPane productTableScrollPane = new JScrollPane(productTable);

        // Invoice Total
        JPanel invoiceTotalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel invoiceTotalLabel = new JLabel("Total: ");
        invoiceTotalArea = new JTextArea(1, 10);
        invoiceTotalArea.setEditable(false);
        invoiceTotalPanel.add(invoiceTotalLabel);
        invoiceTotalPanel.add(invoiceTotalArea);

        // Add Invoice Button
        JButton addInvoiceButton = new JButton("Add Invoice");
        addInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String invoiceNumber = invoiceNumberField.getText();
                String clientName = invoiceClientField.getText();
                String invoiceDate = invoiceDateField.getText();
                String dueDate = invoiceDueDateField.getText();
                Client client = findClientByName(clientName);

                if (!invoiceNumber.isEmpty() && client != null) {
                    Invoice invoice = new Invoice(invoiceNumber, client, invoiceDate, dueDate);
                    invoices.add(invoice);
                    invoiceListModel.addElement(invoice.getInvoiceNumber());
                    resetInvoiceForm();
                }
            }
        });

        invoiceDetailsPanel.add(invoiceFormPanel, BorderLayout.NORTH);
        invoiceDetailsPanel.add(productTableScrollPane, BorderLayout.CENTER);
        invoiceDetailsPanel.add(invoiceTotalPanel, BorderLayout.SOUTH);
        invoiceDetailsPanel.add(addInvoiceButton, BorderLayout.EAST);

        invoicePanel.add(invoiceListPanel, BorderLayout.WEST);
        invoicePanel.add(invoiceDetailsPanel, BorderLayout.CENTER);








        
        // vendors Panel
        JPanel vendorPanel = new JPanel();
        vendorPanel.setLayout(new BorderLayout());

        // Left Panel (vendors List)
        JPanel vendorListPanel = new JPanel();
        vendorListPanel.setLayout(new BorderLayout());

        vendorListModel = new DefaultListModel<>();
        vendorList = new JList<>(vendorListModel);

        JScrollPane vendorScrollPane = new JScrollPane(vendorList);

        vendorListPanel.add(vendorScrollPane, BorderLayout.CENTER);

        // Right Panel (vendor Details)
        JPanel vendorDetailsPanel = new JPanel();
        vendorDetailsPanel.setLayout(new BorderLayout());

        vendorNameField = new JTextField(20);
        JButton createVendorButton = new JButton("Create Vendor");

        JPanel vendorFormPanel = new JPanel();
        vendorFormPanel.add(new JLabel("Vendor Name: "));
        vendorFormPanel.add(vendorNameField);
        vendorFormPanel.add(createVendorButton);

        vendorDescriptionArea = new JTextArea(10, 30);
        vendorDescriptionArea.setEditable(false);

        vendorDetailsPanel.add(vendorFormPanel, BorderLayout.NORTH);
        vendorDetailsPanel.add(new JScrollPane(vendorDescriptionArea), BorderLayout.CENTER);

        vendorPanel.add(vendorListPanel, BorderLayout.WEST);
        vendorPanel.add(vendorDetailsPanel, BorderLayout.CENTER);


   // Edit vendor Button
     JButton editVendorButton = new JButton("Edit Vendor");
     vendorDetailsPanel.add(editVendorButton, BorderLayout.SOUTH);

     editVendorButton.addActionListener(e -> {
         int selectedIndex = vendorList.getSelectedIndex();
         if (selectedIndex != -1) {
             Vendor selectedVendor = vendors.get(selectedIndex);
             showEditVendorDialog(selectedVendor);
         }
     });

/*


        // Client First Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        clientFormPanel.add(new JLabel("First Name: "), gbc);

        clientFirstNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        clientFormPanel.add(clientFirstNameField, gbc);

        // Client Last Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        clientFormPanel.add(new JLabel("Last Name: "), gbc);

        clientLastNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        clientFormPanel.add(clientLastNameField, gbc);

        // Client Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        clientFormPanel.add(new JLabel("Email: "), gbc);

        clientEmailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        clientFormPanel.add(clientEmailField, gbc);

        // Client Phone
        gbc.gridx = 0;
        gbc.gridy = 3;
        clientFormPanel.add(new JLabel("Phone: "), gbc);

        clientPhoneField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        clientFormPanel.add(clientPhoneField, gbc);

        // Client Billing Address
        gbc.gridx = 0;
        gbc.gridy = 4;
        clientFormPanel.add(new JLabel("Billing Address: "), gbc);

        clientBillingAddressField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        clientFormPanel.add(clientBillingAddressField, gbc);

        // Client Shipping Address
        gbc.gridx = 0;
        gbc.gridy = 5;
        clientFormPanel.add(new JLabel("Shipping Address: "), gbc);

        clientShippingAddressField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        clientFormPanel.add(clientShippingAddressField, gbc);

        // Create Client Button
        createClientButton = new JButton("Create Client");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        clientFormPanel.add(createClientButton, gbc);

        // Edit Client Button
        editClientButton = new JButton("Edit Client");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        clientFormPanel.add(editClientButton, gbc);

        // Delete Client Button
        deleteClientButton = new JButton("Delete Client");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        clientFormPanel.add(deleteClientButton, gbc);

        clientDescriptionArea = new JTextArea(10, 30);
        clientDescriptionArea.setEditable(false);

        clientDetailsPanel.add(clientFormPanel, BorderLayout.NORTH);
        clientDetailsPanel.add(new JScrollPane(clientDescriptionArea), BorderLayout.CENTER);

        clientPanel.add(clientListPanel, BorderLayout.WEST);
        clientPanel.add(clientDetailsPanel, BorderLayout.CENTER);


*/






        // Add panels to the main panel

        mainPanel.add(clientPanel, "CLIENTS");
        mainPanel.add(creditPanel, "CREDITS");
        mainPanel.add(productPanel, "PRODUCTS");
        mainPanel.add(invoicePanel, "INVOICES");






        mainPanel.add(vendorPanel, "VENDORS");







        // Add Action Listeners
        clientsButton.addActionListener(e -> cardLayout.show(mainPanel, "CLIENTS"));
        creditsButton.addActionListener(e -> cardLayout.show(mainPanel, "CREDITS"));
        productsButton.addActionListener(e -> cardLayout.show(mainPanel, "PRODUCTS"));
        invoicesButton.addActionListener(e -> cardLayout.show(mainPanel, "INVOICES"));





        vendorsButton.addActionListener(e -> cardLayout.show(mainPanel, "VENDORS"));

       







        createClientButton.addActionListener(e -> {
            String clientName = clientNameField.getText();
            if (!clientName.isEmpty()) {
                Client client = new Client(clientName, clientName, clientName, clientName, clientName, clientName);
                clients.add(client);
                clientListModel.addElement(client.getFirstName());
                clientNameField.setText("");
            }
        });












        createVendorButton.addActionListener(e -> {
            String vendorName = vendorNameField.getText();
            if (!vendorName.isEmpty()) {
                Vendor vendor = new Vendor(vendorName , vendorName , vendorName , vendorName , vendorName , vendorName );
                vendors.add(vendor);
                vendorListModel.addElement(vendor.getFirstName());
                vendorNameField.setText("");
            }
        });










        createCreditButton.addActionListener(e -> {
            String creditName = creditNameField.getText();
            if (!creditName.isEmpty()) {
                Credit credit = new Credit(creditName , creditName , creditName , creditName , creditName , creditName );
                credits.add(credit);
                creditListModel.addElement(credit.getCreditNumber());
                creditNameField.setText("");
            }
        });

        // Initialize clients, credits, products, and invoices lists
        clients = new ArrayList<>();
        credits = new ArrayList<>();
        products = new ArrayList<>();
        invoices = new ArrayList<>();







        vendors = new ArrayList<>();








        // Set the initial visibility of panels
        cardLayout.show(mainPanel, "CLIENTS");

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // List selection listener for products
        productList.addListSelectionListener(e -> {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                Product selectedProduct = products.get(selectedIndex);
                productCategoryField.setText(selectedProduct.getCategory());
                productDefaultQuantityField.setText(String.valueOf(selectedProduct.getDefaultQuantity()));
                productMaxQuantityField.setText(String.valueOf(selectedProduct.getMaxQuantity()));
                productDetailsArea.setText(selectedProduct.toString());
            }
        });

        // List selection listener for invoices
        invoiceList.addListSelectionListener(e -> {
            int selectedIndex = invoiceList.getSelectedIndex();
            if (selectedIndex != -1) {
                Invoice selectedInvoice = invoices.get(selectedIndex);
                showInvoiceDetails(selectedInvoice);
            }
        });
    }

    private void showInvoiceDetails(Invoice invoice) {
        invoiceNumberField.setText(invoice.getInvoiceNumber());
        invoiceClientField.setText(invoice.getClient().getFirstName());
        invoiceDateField.setText(invoice.getInvoiceDate());
        invoiceDueDateField.setText(invoice.getDueDate());
        invoiceTableModel.setRowCount(0); // Clear the table

        for (InvoiceItem item : invoice.getItems()) {
            Object[] row = new Object[4];
            row[0] = item.getProduct().getName();
            row[1] = item.getQuantity();
            row[2] = item.getProduct().getDefaultPrice();
            row[3] = item.getTotal();
            invoiceTableModel.addRow(row);
        }

        invoiceTotalArea.setText(String.valueOf(invoice.getTotal()));
    }

    private Client findClientByName(String name) {
        for (Client client : clients) {
            if (client.getFirstName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }








     private Vendor findVendorByName(String name) {
        for (Vendor vendor : vendors) {
            if (vendor.getFirstName().equalsIgnoreCase(name)) {
                return vendor;
            }
        }
        return null;
    }








    private void resetInvoiceForm() {
        invoiceNumberField.setText("");
        invoiceClientField.setText("");
        invoiceDateField.setText("");
        invoiceDueDateField.setText("");
        invoiceTableModel.setRowCount(0);
        invoiceTotalArea.setText("");
    }









    
   // Custom method to show the custom dialog for editing client details
private void showEditClientDialog(Client client) {
    String firstName = promptForString("First Name:", client.getFirstName());
    String lastName = promptForString("Last Name:", client.getLastName());
    String address = promptForString("Address:", client.getAddress());
    String shippingAddress = promptForString("Shipping Address:", client.getShippingAddress());
    String phoneNumber = promptForPhoneNumber("Phone Number:", client.getPhoneNumber());
    String emailAddress = promptForEmailAddress("Email Address:", client.getEmailAddress());

    if (firstName != null && lastName != null && address != null && shippingAddress != null &&
            phoneNumber != null && emailAddress != null) {
        // Update the client details with the new values
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAddress(address);
        client.setShippingAddress(shippingAddress);
        client.setPhoneNumber(phoneNumber);
        client.setEmailAddress(emailAddress);

        // Update the client list model
        int selectedIndex = clientList.getSelectedIndex();
        if (selectedIndex != -1) {
            clientListModel.setElementAt(client.getFullName(), selectedIndex);
        }

        // Update the client details on the right side of the screen
        clientDescriptionArea.setText(client.toString());
    }
}

// Custom method to prompt for a non-empty string input
private String promptForString(String message, String initialValue) {
    while (true) {
        String input = JOptionPane.showInputDialog(this, message, initialValue);
        if (input == null) {
            // User clicked Cancel, return null
            return null;
        } else if (input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a non-empty value.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            return input.trim();
        }
    }
}

// Custom method to prompt for phone number input with validation
private String promptForPhoneNumber(String message, String initialValue) {
    while (true) {
        String phoneNumber = JOptionPane.showInputDialog(this, message, initialValue);
        if (phoneNumber == null) {
            // User clicked Cancel, return null
            return null;
        } else if (!phoneNumber.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter an 8-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            return phoneNumber;
        }
    }
}

// Custom method to prompt for email address input with validation
private String promptForEmailAddress(String message, String initialValue) {
    while (true) {
        String emailAddress = JOptionPane.showInputDialog(this, message, initialValue);
        if (emailAddress == null) {
            // User clicked Cancel, return null
            return null;
        } else if (!isValidEmailAddress(emailAddress)) {
            JOptionPane.showMessageDialog(this, "Invalid email address. Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            return emailAddress;
        }
    }
}

// Method to validate email address using a basic regex pattern
private boolean isValidEmailAddress(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
    return email.matches(emailRegex);
}








// Custom method to show the custom dialog for editing vendor details
private void showEditVendorDialog(Vendor vendor) {
    String firstNamev = promptForString("First Name:", vendor.getFirstName());
    String lastNamev = promptForString("Last Name:", vendor.getLastName());
    String addressv = promptForString("Address:", vendor.getAddress());
    String phonenumberv = promptForString("Phone Number:", vendor.getphonenumberv());
    String websitev = promptForString("Website:", vendor.getwebsitev());
    String emailAddressv = promptForEmailAddress("Email Address:",vendor.getEmailAddress());

    if (firstNamev != null && lastNamev != null && addressv != null && phonenumberv != null &&
            websitev != null && emailAddressv != null) {
        // Update the client details with the new values
        vendor.setFirstName(firstNamev);
        vendor.setLastName(lastNamev);
        vendor.setAddress(addressv);
        vendor.setphonenumberv(phonenumberv);
        vendor.setwebsitev(websitev);
        vendor.setEmailAddress(emailAddressv);

        // Update the vendor list model
        int selectedIndex = vendorList.getSelectedIndex();
        if (selectedIndex != -1) {
            vendorListModel.setElementAt(vendor.getFullName(), selectedIndex);
        }

        // Update the client details on the right side of the screen
        vendorDescriptionArea.setText(vendor.toString());
    }
}
// Custom method to show the custom dialog for editing credit details
private void showEditCreditDialog(Credit credit) {
    String clientname = promptForString("Client name:", credit.getClientName());
    String creditdate = promptForString("Credit Date:", credit.getCreditDate());
    String validuntil = promptForString("Valid Until:", credit.getValidUntil());
    String partialdeposit = promptForString("Partial/Deposit:", credit.getPartialDeposit());
    String creditnumber = promptForPhoneNumber("Credit Number:", credit.getCreditNumber());
    String poc = promptForEmailAddress("PO#:", credit.getpoc());

    if (clientname != null && creditdate != null && validuntil != null && partialdeposit != null &&
           creditnumber != null && poc != null) {
        // Update the credit details with the new values
        credit.setClientName(clientname);
        credit.setCreditDate(creditdate);
        credit.setValidUntil(validuntil);
        credit.setPartialDeposit(partialdeposit);
        credit.setCreditNumber(creditnumber);
        credit.setpoc(poc);

        // Update the credit list model
        int selectedIndex = creditList.getSelectedIndex();
        if (selectedIndex != -1) {
            creditListModel.setElementAt(credit.getCreditNumber(), selectedIndex);
        }

        // Update the credit details on the right side of the screen
        creditDescriptionArea.setText(credit.toString());
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvoiceManagementApp app = new InvoiceManagementApp();
            app.setVisible(true);
        });
    }

   class Client {
    private String firstName;
    private String lastName;
    private String address;
    private String shippingAddress;
    private String phoneNumber;
    private String emailAddress;

    public Client(String firstName, String lastName, String address, String shippingAddress,
                  String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.shippingAddress = shippingAddress;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAddress: " + address +
                "\nShipping Address: " + shippingAddress +
                "\nPhone Number: " + phoneNumber +
                "\nEmail Address: " + emailAddress;
    }
}






     

    class Credit {
    private String clientname;
    private String creditdate;
    private String validuntil;
    private String partialdeposit;
    private String creditnumber;
    private String poc;

    public Credit(String clientname, String creditdate, String validuntil, String partialdeposit,
                  String creditnumber, String po) {
        this.clientname = clientname;
        this.creditdate = creditdate;
        this.validuntil = validuntil;
        this.partialdeposit = partialdeposit;
        this.creditnumber = creditnumber;
        this.poc = poc;
    }

    public String getClientName() {
        return clientname;
    }

    public void setClientName(String clientname) {
        this.clientname = clientname;
    }

    public String getCreditDate() {
        return creditdate;
    }

    public void setCreditDate(String creditdate) {
        this.creditdate = creditdate;
    }

    public String getValidUntil() {
        return validuntil;
    }

    public void setValidUntil(String validuntil) {
        this.validuntil = validuntil;
    }

    public String getPartialDeposit() {
        return partialdeposit;
    }

    public void setPartialDeposit(String partialdeposit) {
        this.partialdeposit = partialdeposit;
    }

    public String getCreditNumber() {
        return creditnumber;
    }

    public void setCreditNumber(String creditnumber) {
        this.creditnumber = creditnumber;
    }

    public String getpoc() {
        return poc;
    }

    public void setpoc(String poc) {
        this.poc = poc;
    }

    

    @Override
    public String toString() {
        return "Client Name: " + clientname +
                "\nCredit Date: " + creditdate+
                "\nValid Until: " + validuntil +
                "\nPartial/Deposit: " + partialdeposit+
                "\nCredit Number: " + creditnumber+
                "\nPO#: " + poc;
    }
}




    class Product {
        private String name;
        private String description;
        private String category;
        private int defaultQuantity;
        private int maxQuantity;
        private double defaultPrice;

        public Product(String name, String description) {
            this.name = name;
            this.description = description;
            this.category = "";
            this.defaultQuantity = 0;
            this.maxQuantity = 0;
            this.defaultPrice = 0.0;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getDefaultQuantity() {
            return defaultQuantity;
        }

        public void setDefaultQuantity(int defaultQuantity) {
            this.defaultQuantity = defaultQuantity;
        }

        public int getMaxQuantity() {
            return maxQuantity;
        }

        public void setMaxQuantity(int maxQuantity) {
            this.maxQuantity = maxQuantity;
        }

        public double getDefaultPrice() {
            return defaultPrice;
        }

        public void setDefaultPrice(double defaultPrice) {
            this.defaultPrice = defaultPrice;
        }

        @Override
        public String toString() {
            return "Product: " + name + "\n" +
                    "Description: " + description + "\n" +
                    "Category: " + category + "\n" +
                    "Default Quantity: " + defaultQuantity + "\n" +
                    "Max Quantity: " + maxQuantity;
        }
    }

    class Invoice {
        private String invoiceNumber;
        private Client client;
        private String invoiceDate;
        private String dueDate;
        private List<InvoiceItem> items;

        public Invoice(String invoiceNumber, Client client, String invoiceDate, String dueDate) {
            this.invoiceNumber = invoiceNumber;
            this.client = client;
            this.invoiceDate = invoiceDate;
            this.dueDate = dueDate;
            this.items = new ArrayList<>();
        }

        public String getInvoiceNumber() {
            return invoiceNumber;
        }

        public Client getClient() {
            return client;
        }

        public String getInvoiceDate() {
            return invoiceDate;
        }

        public String getDueDate() {
            return dueDate;
        }

        public List<InvoiceItem> getItems() {
            return items;
        }

        public void addItem(Product product, int quantity) {
            InvoiceItem item = new InvoiceItem(product, quantity);
            items.add(item);
        }

        public double getTotal() {
            double total = 0.0;
            for (InvoiceItem item : items) {
                total += item.getTotal();
            }
            return total;
        }
    }

    class InvoiceItem {
        private Product product;
        private int quantity;

        public InvoiceItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotal() {
            return product.getDefaultPrice() * quantity;
        }
    }

  class Vendor {
    private String firstNamev;
    private String lastNamev;
    private String addressv;
    private String phonenumberv;
    private String websitev;
    private String emailAddressv;

    public Vendor(String firstNamev, String lastNamev, String addressv, String phonenumberv,
                  String websitev, String emailAddressv) {
        this.firstNamev = firstNamev;
        this.lastNamev = lastNamev;
        this.addressv = addressv;
        this.phonenumberv = phonenumberv;
        this.websitev = websitev;
        this.emailAddressv = emailAddressv;
    }

    public String getFirstName() {
        return firstNamev;
    }

    public void setFirstName(String firstNamev) {
        this.firstNamev = firstNamev;
    }

    public String getLastName() {
        return lastNamev;
    }

    public void setLastName(String lastNamev) {
        this.lastNamev = lastNamev;
    }

    public String getAddress() {
        return addressv;
    }

    public void setAddress(String addressv) {
        this.addressv = addressv;
    }

    public String getphonenumberv() {
        return phonenumberv;
    }

    public void setphonenumberv(String phonenumberv) {
        this.phonenumberv = phonenumberv;
    }

    public String getwebsitev() {
        return websitev;
    }

    public void setwebsitev(String websitev) {
        this.websitev = websitev;
    }

    public String getEmailAddress() {
        return emailAddressv;
    }

    public void setEmailAddress(String emailAddressv) {
        this.emailAddressv = emailAddressv;
    }

    public String getFullName() {
        return firstNamev + " " + lastNamev;
    }

    @Override
    public String toString() {
        return "First Name: " + firstNamev +
                "\nLast Name: " + lastNamev +
                "\nAddress: " + addressv +
                "\nPhone Number: " + phonenumberv+
                "\nWebsite: " + websitev +
                "\nEmail Address: " + emailAddressv;
    }
}




    

}






