/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.projectGC.view;

import com.projectGC.controller.algorithm.SelectionSortByName;
import com.projectGC.controller.algorithm.BinarySearch;
import com.projectGC.controller.algorithm.InsertionSort;
import com.projectGC.controller.algorithm.MergeSort;
import com.projectGC.model.ProjectGConsole;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @LmuID 23048628
 * @author Suprasiddhi
 */
public class projectGC extends javax.swing.JFrame {

    private final LinkedList<ProjectGConsole> consoleList = new LinkedList<ProjectGConsole>();
    private java.awt.CardLayout cardLayout;
    private final LinkedList<ProjectGConsole> consoleDeviceDetailsList = new LinkedList<ProjectGConsole>();
    private final SelectionSortByName selectionSortByName = new SelectionSortByName();
    private final BinarySearch binarySearch = new BinarySearch();
    private final InsertionSort insertionSort = new InsertionSort();
    private final MergeSort mergeSort = new MergeSort();

    /**
     * Creates new form projectGC
     */
    public projectGC() {
        initComponents();
        initializeLayout();
        initializeData();
    }

    public void addConsoleToTable(List<ProjectGConsole> consoleList) {
        DefaultTableModel model = (DefaultTableModel) tblCartDetails.getModel();
        model.setRowCount(0);
        for (ProjectGConsole Console : consoleList) {
            model.addRow(new Object[]{Console.getConsoleName(), Console.getBrand(), Console.getQuantity(), Console.getReleaseDate()});

        }
    }

    public void addConsoleToDeviceDetailsTable(List<ProjectGConsole> consoleDeviceDetailsList) {
        DefaultTableModel model = (DefaultTableModel) tblDeviceContent.getModel();
        model.setRowCount(0);
        for (ProjectGConsole Console : consoleDeviceDetailsList) {
            model.addRow(new Object[]{Console.getConsoleName(), Console.getBrand(), Console.getTechnicalFeature(),
                Console.getAdditionalFeature(), Console.getEnergyEfficiency(), Console.getReleaseDate(), Console.getPrice()});

        }
    }

    public void addRemoConsoleToTable() {
        DefaultTableModel model = (DefaultTableModel) tblCartDetails.getModel();
        model.setRowCount(0);
    }

    private Boolean UpdateCart() {
        String Name = txtFldCartConsoleName.getText();
        String Brand = txtFldCartBrand.getText();
        int Quantity = Integer.parseInt(txtFldCartQuantity.getText());
        String ReleaseDate = txtFldCartReleaseDate.getText();
        ProjectGConsole Console = new ProjectGConsole(Name, Quantity, Brand, ReleaseDate);

        if (txtFldCartConsoleName.getText().isEmpty() || txtFldCartBrand.getText().isEmpty() || txtFldCartQuantity.getText().isEmpty()
                || txtFldCartReleaseDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the required details!!", "Empty Text Field", JOptionPane.ERROR_MESSAGE);
        } else if (Quantity == 0) {
            JOptionPane.showMessageDialog(this, "Enter a valid Quantity number!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            for (ProjectGConsole ConsoleUpdate : consoleList) {
                if (Name.equals(ConsoleUpdate.getConsoleName()) && Brand.equals(ConsoleUpdate.getBrand())
                        && ReleaseDate.equals(ConsoleUpdate.getReleaseDate())) {
                    ConsoleUpdate.setQuantity(Console.getQuantity());
                    addConsoleToTable(consoleList);
                    return true;
                }
            }
            JOptionPane.showMessageDialog(this, "Please enter the correct data!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            addConsoleToTable(consoleList);
        }
        return false;
    }

    public boolean addToCart() {
        String Name = txtFldDeviceDetailsConsoleName.getText();
        String Brand = txtFldDeviceDetailsBrand.getText();
        int Quantity = Integer.parseInt(txtFldDeviceDetailsQuantity.getText());
        String ReleaseDate = txtFldDeviceDetailsReleaseDate.getText();
        if (txtFldDeviceDetailsConsoleName.getText().isEmpty() || txtFldDeviceDetailsBrand.getText().isEmpty()
                || txtFldDeviceDetailsQuantity.getText().isEmpty() || txtFldDeviceDetailsReleaseDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the required details!!", "Empty Text Field", JOptionPane.ERROR_MESSAGE);
        } else if (Quantity == 0) {
            JOptionPane.showMessageDialog(this, "Enter a valid Quantity number!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            for (ProjectGConsole console1 : consoleList) {
                if (console1.getConsoleName().equals(Name)) {
                    JOptionPane.showMessageDialog(this, "This product has already been added!! Please check and update your cart!!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);

                    return false;
                }
            }
            ProjectGConsole addproduct = new ProjectGConsole(Name, Quantity, Brand, ReleaseDate);
            consoleList.add(addproduct);
            addConsoleToTable(consoleList);
            return true;
        }
        return false;
    }

    public Boolean deletedConsole(String Name) {
        for (ProjectGConsole console : consoleList) {
            if (console.getConsoleName().equals(Name)) {
                consoleList.remove(console);
                JOptionPane.showMessageDialog(this, "Deleted Successfully!!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                addConsoleToTable(consoleList);
                return true;
            }else{
                JOptionPane.showMessageDialog(this, "Please enter the correct data!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainScreen = new javax.swing.JPanel();
        pnlLogoTitleSection = new javax.swing.JPanel();
        lblMainTitle = new javax.swing.JLabel();
        bntLogOut = new javax.swing.JButton();
        tabPnlMain = new javax.swing.JTabbedPane();
        pnlHome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaWelcometext = new javax.swing.JTextArea();
        pnlDevices = new javax.swing.JPanel();
        scrlPnlDeviceDetails = new javax.swing.JScrollPane();
        tblDeviceContent = new javax.swing.JTable();
        txtFldDeviceDetailsSearch = new javax.swing.JTextField();
        bntDeviceDetailsSearch = new javax.swing.JButton();
        txtFldDeviceDetailsConsoleName = new javax.swing.JTextField();
        txtFldDeviceDetailsReleaseDate = new javax.swing.JTextField();
        txtFldDeviceDetailsQuantity = new javax.swing.JTextField();
        bntDeviceDetailsAddToCart = new javax.swing.JButton();
        txtFldDeviceDetailsBrand = new javax.swing.JTextField();
        lblDeviceDetailsConsoleName = new javax.swing.JLabel();
        lblDeviceDetailsBrand = new javax.swing.JLabel();
        lblDeviceDetailsQuantity = new javax.swing.JLabel();
        lblDeviceDetailsReleaseDate = new javax.swing.JLabel();
        lblDeviceDetails = new javax.swing.JLabel();
        lblDeviceDetailsSearch = new javax.swing.JLabel();
        lblDeviceDetailsSortBy = new javax.swing.JLabel();
        bntDeviceVetailsClear = new javax.swing.JButton();
        bntDeviceDetailsSortBy = new javax.swing.JButton();
        comboxDeviceDetailsSortBy = new javax.swing.JComboBox<>();
        bntDeviceDetailsRefresh = new javax.swing.JButton();
        pnlCart = new javax.swing.JPanel();
        scrlPnlCart = new javax.swing.JScrollPane();
        tblCartDetails = new javax.swing.JTable();
        txtFldCartConsoleName = new javax.swing.JTextField();
        txtFldCartQuantity = new javax.swing.JTextField();
        txtFldCartBrand = new javax.swing.JTextField();
        bntCartUpdate = new javax.swing.JButton();
        bntCartDelete = new javax.swing.JButton();
        bntCartOrder = new javax.swing.JButton();
        bntCartClear = new javax.swing.JButton();
        txtFldCartReleaseDate = new javax.swing.JTextField();
        lblCartConsoleName = new javax.swing.JLabel();
        lblCartQuantity = new javax.swing.JLabel();
        lblCartBrand = new javax.swing.JLabel();
        lblCartReleaseDate = new javax.swing.JLabel();
        lblCart = new javax.swing.JLabel();
        lblCartSortBy = new javax.swing.JLabel();
        comboxCartSortBy = new javax.swing.JComboBox<>();
        bntCartSort = new javax.swing.JButton();
        pnlSupport = new javax.swing.JPanel();
        lblSupportTxt = new javax.swing.JLabel();
        txtFldSupportQue = new javax.swing.JTextField();
        bntSupportSubmit = new javax.swing.JButton();
        pnlLogInScreen = new javax.swing.JPanel();
        pnlLogInBox = new javax.swing.JPanel();
        lblLogInTitle = new javax.swing.JLabel();
        txtFldLogInUsername = new javax.swing.JTextField();
        lblLoginTxt = new javax.swing.JLabel();
        bntLogIn = new javax.swing.JButton();
        lblLogInTxt2 = new javax.swing.JLabel();
        lblLogInTxt3 = new javax.swing.JLabel();
        pwdFldLogInPassword = new javax.swing.JPasswordField();
        lblProjectGCTxt = new javax.swing.JLabel();
        lblProjectGCTxt2 = new javax.swing.JLabel();
        lblProjectGCTxt3 = new javax.swing.JLabel();
        lblProjectGCTitle = new javax.swing.JLabel();
        lblProjectGCLogo = new javax.swing.JLabel();
        lblProjectGCLogInError = new javax.swing.JLabel();

        pnlMainScreen.setBackground(new java.awt.Color(51, 102, 0));
        pnlMainScreen.setForeground(new java.awt.Color(204, 204, 204));
        pnlMainScreen.setMaximumSize(new java.awt.Dimension(860, 500));
        pnlMainScreen.setMinimumSize(new java.awt.Dimension(860, 500));
        pnlMainScreen.setPreferredSize(new java.awt.Dimension(860, 500));

        pnlLogoTitleSection.setBackground(new java.awt.Color(204, 204, 204));
        pnlLogoTitleSection.setForeground(new java.awt.Color(0, 102, 51));

        lblMainTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblMainTitle.setForeground(new java.awt.Color(51, 102, 0));
        lblMainTitle.setText("PROJECT G. CONSOLE");

        bntLogOut.setBackground(new java.awt.Color(51, 102, 0));
        bntLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntLogOut.setForeground(new java.awt.Color(204, 204, 204));
        bntLogOut.setText("Log Out");
        bntLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogoTitleSectionLayout = new javax.swing.GroupLayout(pnlLogoTitleSection);
        pnlLogoTitleSection.setLayout(pnlLogoTitleSectionLayout);
        pnlLogoTitleSectionLayout.setHorizontalGroup(
            pnlLogoTitleSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoTitleSectionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMainTitle)
                .addGap(129, 129, 129)
                .addComponent(bntLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pnlLogoTitleSectionLayout.setVerticalGroup(
            pnlLogoTitleSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoTitleSectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLogoTitleSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMainTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabPnlMain.setBackground(new java.awt.Color(51, 102, 0));
        tabPnlMain.setForeground(new java.awt.Color(204, 204, 204));

        pnlHome.setBackground(new java.awt.Color(51, 102, 0));

        txtAreaWelcometext.setBackground(new java.awt.Color(51, 102, 0));
        txtAreaWelcometext.setColumns(20);
        txtAreaWelcometext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtAreaWelcometext.setForeground(new java.awt.Color(204, 204, 204));
        txtAreaWelcometext.setRows(5);
        txtAreaWelcometext.setText("Welcome to Project G. Console !!\n\nYour ultimate destination for the lastest gaming consoles, accessories, and exclusive deals.\nWeather you're a PlayStation pro, Xbox enthusiast, or a Nintendo fanatic, we've got \neverything you need to level up your gaming experience. Explore our wide selection of top-tire \nconsoles, find accessories to enhance your setup, and stay ahead with pre-orders for \nupcoming releases.\n\nGame on, Anytime, Anywhere !!");
        txtAreaWelcometext.setBorder(null);
        jScrollPane1.setViewportView(txtAreaWelcometext);

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        tabPnlMain.addTab("Home", pnlHome);

        pnlDevices.setBackground(new java.awt.Color(51, 102, 0));

        tblDeviceContent.setBackground(new java.awt.Color(204, 204, 204));
        tblDeviceContent.setForeground(new java.awt.Color(51, 102, 0));
        tblDeviceContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Console Name", "Brand", "Technical Features", "Additinal Feature", "Energy Efficiency", "Release Date", "Price"
            }
        ));
        tblDeviceContent.setSelectionForeground(new java.awt.Color(51, 102, 0));
        scrlPnlDeviceDetails.setViewportView(tblDeviceContent);

        txtFldDeviceDetailsSearch.setBackground(new java.awt.Color(204, 204, 204));
        txtFldDeviceDetailsSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFldDeviceDetailsSearch.setForeground(new java.awt.Color(51, 102, 0));

        bntDeviceDetailsSearch.setBackground(new java.awt.Color(204, 204, 204));
        bntDeviceDetailsSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntDeviceDetailsSearch.setForeground(new java.awt.Color(51, 102, 0));
        bntDeviceDetailsSearch.setText("Search");
        bntDeviceDetailsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeviceDetailsSearchActionPerformed(evt);
            }
        });

        txtFldDeviceDetailsConsoleName.setBackground(new java.awt.Color(204, 204, 204));
        txtFldDeviceDetailsConsoleName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFldDeviceDetailsConsoleName.setForeground(new java.awt.Color(51, 102, 0));
        txtFldDeviceDetailsConsoleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldDeviceDetailsConsoleNameActionPerformed(evt);
            }
        });

        txtFldDeviceDetailsReleaseDate.setBackground(new java.awt.Color(204, 204, 204));
        txtFldDeviceDetailsReleaseDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFldDeviceDetailsReleaseDate.setForeground(new java.awt.Color(51, 102, 0));
        txtFldDeviceDetailsReleaseDate.setActionCommand("<Not Set>");
        txtFldDeviceDetailsReleaseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldDeviceDetailsReleaseDateActionPerformed(evt);
            }
        });

        txtFldDeviceDetailsQuantity.setBackground(new java.awt.Color(204, 204, 204));
        txtFldDeviceDetailsQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFldDeviceDetailsQuantity.setForeground(new java.awt.Color(51, 102, 0));

        bntDeviceDetailsAddToCart.setBackground(new java.awt.Color(204, 204, 204));
        bntDeviceDetailsAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntDeviceDetailsAddToCart.setForeground(new java.awt.Color(51, 102, 0));
        bntDeviceDetailsAddToCart.setText("Add to Cart");
        bntDeviceDetailsAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeviceDetailsAddToCartActionPerformed(evt);
            }
        });

        txtFldDeviceDetailsBrand.setBackground(new java.awt.Color(204, 204, 204));
        txtFldDeviceDetailsBrand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtFldDeviceDetailsBrand.setForeground(new java.awt.Color(51, 102, 0));

        lblDeviceDetailsConsoleName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeviceDetailsConsoleName.setForeground(new java.awt.Color(204, 204, 204));
        lblDeviceDetailsConsoleName.setText("Console Name :");

        lblDeviceDetailsBrand.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeviceDetailsBrand.setForeground(new java.awt.Color(204, 204, 204));
        lblDeviceDetailsBrand.setText("Brand :");

        lblDeviceDetailsQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeviceDetailsQuantity.setForeground(new java.awt.Color(204, 204, 204));
        lblDeviceDetailsQuantity.setText("Quantity");

        lblDeviceDetailsReleaseDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeviceDetailsReleaseDate.setForeground(new java.awt.Color(204, 204, 204));
        lblDeviceDetailsReleaseDate.setText("Release date :");

        lblDeviceDetails.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblDeviceDetails.setForeground(new java.awt.Color(204, 204, 204));
        lblDeviceDetails.setText("Device Details");

        lblDeviceDetailsSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeviceDetailsSearch.setForeground(new java.awt.Color(204, 204, 204));
        lblDeviceDetailsSearch.setText("Search :");

        lblDeviceDetailsSortBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeviceDetailsSortBy.setForeground(new java.awt.Color(204, 204, 204));
        lblDeviceDetailsSortBy.setText("Sort By :");

        bntDeviceVetailsClear.setBackground(new java.awt.Color(204, 204, 204));
        bntDeviceVetailsClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntDeviceVetailsClear.setForeground(new java.awt.Color(0, 102, 0));
        bntDeviceVetailsClear.setText("Clear");
        bntDeviceVetailsClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeviceVetailsClearActionPerformed(evt);
            }
        });

        bntDeviceDetailsSortBy.setBackground(new java.awt.Color(204, 204, 204));
        bntDeviceDetailsSortBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntDeviceDetailsSortBy.setForeground(new java.awt.Color(51, 102, 0));
        bntDeviceDetailsSortBy.setText("Sort");
        bntDeviceDetailsSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeviceDetailsSortByActionPerformed(evt);
            }
        });

        comboxDeviceDetailsSortBy.setBackground(new java.awt.Color(204, 204, 204));
        comboxDeviceDetailsSortBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboxDeviceDetailsSortBy.setForeground(new java.awt.Color(51, 102, 0));
        comboxDeviceDetailsSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Price", "Name" }));

        bntDeviceDetailsRefresh.setBackground(new java.awt.Color(204, 204, 204));
        bntDeviceDetailsRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntDeviceDetailsRefresh.setForeground(new java.awt.Color(51, 102, 0));
        bntDeviceDetailsRefresh.setText("Refresh");
        bntDeviceDetailsRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeviceDetailsRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDevicesLayout = new javax.swing.GroupLayout(pnlDevices);
        pnlDevices.setLayout(pnlDevicesLayout);
        pnlDevicesLayout.setHorizontalGroup(
            pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDevicesLayout.createSequentialGroup()
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDevicesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrlPnlDeviceDetails))
                    .addGroup(pnlDevicesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDeviceDetailsConsoleName, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(lblDeviceDetailsBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFldDeviceDetailsConsoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldDeviceDetailsBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDeviceDetailsQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDeviceDetailsReleaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFldDeviceDetailsReleaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldDeviceDetailsQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntDeviceDetailsAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addContainerGap())
            .addGroup(pnlDevicesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDevicesLayout.createSequentialGroup()
                        .addComponent(lblDeviceDetailsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFldDeviceDetailsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDeviceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntDeviceDetailsSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntDeviceDetailsRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntDeviceVetailsClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeviceDetailsSortBy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntDeviceDetailsSortBy, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(comboxDeviceDetailsSortBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDevicesLayout.setVerticalGroup(
            pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDevicesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeviceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDeviceVetailsClear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDeviceDetailsSortBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntDeviceDetailsRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFldDeviceDetailsSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bntDeviceDetailsSearch)
                        .addComponent(lblDeviceDetailsSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDeviceDetailsSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboxDeviceDetailsSortBy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrlPnlDeviceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDevicesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDevicesLayout.createSequentialGroup()
                                .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFldDeviceDetailsConsoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFldDeviceDetailsQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblDeviceDetailsConsoleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDeviceDetailsQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDevicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFldDeviceDetailsBrand, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFldDeviceDetailsReleaseDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDeviceDetailsBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDeviceDetailsReleaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDevicesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntDeviceDetailsAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        tabPnlMain.addTab("Devices", pnlDevices);

        pnlCart.setBackground(new java.awt.Color(51, 102, 0));

        tblCartDetails.setBackground(new java.awt.Color(204, 204, 204));
        tblCartDetails.setForeground(new java.awt.Color(51, 102, 0));
        tblCartDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Console Name", "Brand", "Quantity", "Release Date"
            }
        ));
        scrlPnlCart.setViewportView(tblCartDetails);

        txtFldCartConsoleName.setBackground(new java.awt.Color(204, 204, 204));
        txtFldCartConsoleName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFldCartConsoleName.setForeground(new java.awt.Color(51, 102, 0));

        txtFldCartQuantity.setBackground(new java.awt.Color(204, 204, 204));
        txtFldCartQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFldCartQuantity.setForeground(new java.awt.Color(51, 102, 0));
        txtFldCartQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldCartQuantityActionPerformed(evt);
            }
        });

        txtFldCartBrand.setBackground(new java.awt.Color(204, 204, 204));
        txtFldCartBrand.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFldCartBrand.setForeground(new java.awt.Color(51, 102, 0));

        bntCartUpdate.setBackground(new java.awt.Color(204, 204, 204));
        bntCartUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCartUpdate.setForeground(new java.awt.Color(51, 102, 0));
        bntCartUpdate.setText("Update");
        bntCartUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCartUpdateActionPerformed(evt);
            }
        });

        bntCartDelete.setBackground(new java.awt.Color(204, 204, 204));
        bntCartDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCartDelete.setForeground(new java.awt.Color(51, 102, 0));
        bntCartDelete.setText("Delete");
        bntCartDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCartDeleteActionPerformed(evt);
            }
        });

        bntCartOrder.setBackground(new java.awt.Color(204, 204, 204));
        bntCartOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCartOrder.setForeground(new java.awt.Color(51, 102, 0));
        bntCartOrder.setText("Order");
        bntCartOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCartOrderActionPerformed(evt);
            }
        });

        bntCartClear.setBackground(new java.awt.Color(204, 204, 204));
        bntCartClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCartClear.setForeground(new java.awt.Color(51, 102, 0));
        bntCartClear.setText("Clear");
        bntCartClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCartClearActionPerformed(evt);
            }
        });

        txtFldCartReleaseDate.setBackground(new java.awt.Color(204, 204, 204));
        txtFldCartReleaseDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFldCartReleaseDate.setForeground(new java.awt.Color(51, 102, 0));

        lblCartConsoleName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCartConsoleName.setForeground(new java.awt.Color(204, 204, 204));
        lblCartConsoleName.setText("Console Name :");

        lblCartQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCartQuantity.setForeground(new java.awt.Color(204, 204, 204));
        lblCartQuantity.setText("Quantity :");

        lblCartBrand.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCartBrand.setForeground(new java.awt.Color(204, 204, 204));
        lblCartBrand.setText("Brand :");

        lblCartReleaseDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCartReleaseDate.setForeground(new java.awt.Color(204, 204, 204));
        lblCartReleaseDate.setText("Release Date :");

        lblCart.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblCart.setForeground(new java.awt.Color(204, 204, 204));
        lblCart.setText("Cart :");

        lblCartSortBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCartSortBy.setForeground(new java.awt.Color(204, 204, 204));
        lblCartSortBy.setText("Sort By :");

        comboxCartSortBy.setBackground(new java.awt.Color(204, 204, 204));
        comboxCartSortBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboxCartSortBy.setForeground(new java.awt.Color(51, 102, 0));
        comboxCartSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Quantity" }));

        bntCartSort.setBackground(new java.awt.Color(204, 204, 204));
        bntCartSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCartSort.setForeground(new java.awt.Color(51, 102, 0));
        bntCartSort.setText("Sort");
        bntCartSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCartSortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCartLayout = new javax.swing.GroupLayout(pnlCart);
        pnlCart.setLayout(pnlCartLayout);
        pnlCartLayout.setHorizontalGroup(
            pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartLayout.createSequentialGroup()
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txtFldCartConsoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCartBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartConsoleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFldCartQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFldCartBrand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(90, 90, 90)
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addComponent(bntCartUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntCartDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addComponent(lblCartReleaseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFldCartReleaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(pnlCartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlPnlCart)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartLayout.createSequentialGroup()
                        .addComponent(lblCart, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(lblCartSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntCartSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboxCartSortBy, 0, 132, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntCartClear, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntCartOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)))
                .addContainerGap())
        );
        pnlCartLayout.setVerticalGroup(
            pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addComponent(bntCartSort, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboxCartSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCartSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bntCartOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblCart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrlPnlCart, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlCartLayout.createSequentialGroup()
                                        .addComponent(lblCartConsoleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCartLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtFldCartConsoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCartQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFldCartQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFldCartBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCartBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addGroup(pnlCartLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFldCartReleaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCartReleaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bntCartUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bntCartDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))))
                    .addGroup(pnlCartLayout.createSequentialGroup()
                        .addComponent(bntCartClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        tabPnlMain.addTab("Cart", pnlCart);

        pnlSupport.setBackground(new java.awt.Color(51, 102, 0));

        lblSupportTxt.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblSupportTxt.setForeground(new java.awt.Color(204, 204, 204));
        lblSupportTxt.setText("How can we help?");

        txtFldSupportQue.setBackground(new java.awt.Color(204, 204, 204));
        txtFldSupportQue.setForeground(new java.awt.Color(51, 102, 0));
        txtFldSupportQue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldSupportQueActionPerformed(evt);
            }
        });

        bntSupportSubmit.setBackground(new java.awt.Color(204, 204, 204));
        bntSupportSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntSupportSubmit.setForeground(new java.awt.Color(51, 102, 0));
        bntSupportSubmit.setText("Submit");

        javax.swing.GroupLayout pnlSupportLayout = new javax.swing.GroupLayout(pnlSupport);
        pnlSupport.setLayout(pnlSupportLayout);
        pnlSupportLayout.setHorizontalGroup(
            pnlSupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupportLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(pnlSupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntSupportSubmit)
                    .addComponent(lblSupportTxt)
                    .addComponent(txtFldSupportQue, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(354, Short.MAX_VALUE))
        );
        pnlSupportLayout.setVerticalGroup(
            pnlSupportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupportLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblSupportTxt)
                .addGap(18, 18, 18)
                .addComponent(txtFldSupportQue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntSupportSubmit)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        tabPnlMain.addTab("Support", pnlSupport);

        javax.swing.GroupLayout pnlMainScreenLayout = new javax.swing.GroupLayout(pnlMainScreen);
        pnlMainScreen.setLayout(pnlMainScreenLayout);
        pnlMainScreenLayout.setHorizontalGroup(
            pnlMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogoTitleSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPnlMain)
                .addContainerGap())
        );
        pnlMainScreenLayout.setVerticalGroup(
            pnlMainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainScreenLayout.createSequentialGroup()
                .addComponent(pnlLogoTitleSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabPnlMain)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(860, 500, 500, 500));
        setMinimumSize(new java.awt.Dimension(860, 500));

        pnlLogInScreen.setBackground(new java.awt.Color(51, 102, 0));
        pnlLogInScreen.setMaximumSize(new java.awt.Dimension(860, 500));
        pnlLogInScreen.setMinimumSize(new java.awt.Dimension(860, 500));
        pnlLogInScreen.setPreferredSize(new java.awt.Dimension(860, 500));

        pnlLogInBox.setBackground(new java.awt.Color(204, 204, 204));

        lblLogInTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblLogInTitle.setForeground(new java.awt.Color(51, 102, 0));
        lblLogInTitle.setText("Log In");

        txtFldLogInUsername.setBackground(new java.awt.Color(153, 153, 153));
        txtFldLogInUsername.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtFldLogInUsername.setForeground(new java.awt.Color(0, 102, 0));
        txtFldLogInUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(51, 102, 0))); // NOI18N
        txtFldLogInUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFldLogInUsernameActionPerformed(evt);
            }
        });

        lblLoginTxt.setBackground(new java.awt.Color(204, 204, 204));
        lblLoginTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblLoginTxt.setForeground(new java.awt.Color(51, 102, 0));
        lblLoginTxt.setText("Don't have an account? Sign up");

        bntLogIn.setBackground(new java.awt.Color(51, 102, 0));
        bntLogIn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        bntLogIn.setForeground(new java.awt.Color(204, 204, 204));
        bntLogIn.setText("Log In");
        bntLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLogInActionPerformed(evt);
            }
        });

        lblLogInTxt2.setBackground(new java.awt.Color(204, 204, 204));
        lblLogInTxt2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblLogInTxt2.setForeground(new java.awt.Color(51, 102, 0));
        lblLogInTxt2.setText("Forgot Password");

        lblLogInTxt3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblLogInTxt3.setForeground(new java.awt.Color(51, 102, 0));
        lblLogInTxt3.setText("Enter the details below");

        pwdFldLogInPassword.setBackground(new java.awt.Color(153, 153, 153));
        pwdFldLogInPassword.setForeground(new java.awt.Color(51, 102, 0));
        pwdFldLogInPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 102, 0))); // NOI18N
        pwdFldLogInPassword.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout pnlLogInBoxLayout = new javax.swing.GroupLayout(pnlLogInBox);
        pnlLogInBox.setLayout(pnlLogInBoxLayout);
        pnlLogInBoxLayout.setHorizontalGroup(
            pnlLogInBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogInBoxLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlLogInBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogInTxt3)
                    .addGroup(pnlLogInBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblLogInTxt2)
                        .addGroup(pnlLogInBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFldLogInUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(lblLogInTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwdFldLogInPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogInBoxLayout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addComponent(lblLoginTxt)
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogInBoxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        pnlLogInBoxLayout.setVerticalGroup(
            pnlLogInBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogInBoxLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblLogInTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogInTxt3)
                .addGap(18, 18, 18)
                .addComponent(txtFldLogInUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdFldLogInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogInTxt2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLoginTxt)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        lblProjectGCTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProjectGCTxt.setForeground(new java.awt.Color(204, 204, 204));
        lblProjectGCTxt.setText("Bring your desired gaming console home");

        lblProjectGCTxt2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProjectGCTxt2.setForeground(new java.awt.Color(204, 204, 204));
        lblProjectGCTxt2.setText("and dive into the world of gaming!");

        lblProjectGCTxt3.setForeground(new java.awt.Color(204, 204, 204));
        lblProjectGCTxt3.setText("Playstation, Xbox, nindendo and many more...");

        lblProjectGCTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblProjectGCTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblProjectGCTitle.setText("PROJECT G. CONSOLE");

        lblProjectGCLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/projectGC/resources/PROJECT G. CONSOLE_1.png"))); // NOI18N

        lblProjectGCLogInError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProjectGCLogInError.setForeground(new java.awt.Color(255, 0, 0));
        lblProjectGCLogInError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlLogInScreenLayout = new javax.swing.GroupLayout(pnlLogInScreen);
        pnlLogInScreen.setLayout(pnlLogInScreenLayout);
        pnlLogInScreenLayout.setHorizontalGroup(
            pnlLogInScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogInScreenLayout.createSequentialGroup()
                .addGroup(pnlLogInScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLogInScreenLayout.createSequentialGroup()
                        .addComponent(lblProjectGCLogo)
                        .addGap(0, 407, Short.MAX_VALUE))
                    .addGroup(pnlLogInScreenLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pnlLogInScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProjectGCTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                            .addGroup(pnlLogInScreenLayout.createSequentialGroup()
                                .addGroup(pnlLogInScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProjectGCTxt2)
                                    .addComponent(lblProjectGCTxt3)
                                    .addComponent(lblProjectGCTitle))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(pnlLogInScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLogInBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProjectGCLogInError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
        );
        pnlLogInScreenLayout.setVerticalGroup(
            pnlLogInScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogInScreenLayout.createSequentialGroup()
                .addGroup(pnlLogInScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLogInScreenLayout.createSequentialGroup()
                        .addComponent(lblProjectGCLogo)
                        .addGap(21, 21, 21)
                        .addComponent(lblProjectGCTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProjectGCTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProjectGCTxt2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProjectGCTxt3))
                    .addGroup(pnlLogInScreenLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblProjectGCLogInError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlLogInBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlLogInScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlLogInScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFldLogInUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldLogInUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldLogInUsernameActionPerformed

    private void bntLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLogInActionPerformed
        // TODO add your handling code here:
        // Get the username and password input
        String username = txtFldLogInUsername.getText();
        String password = new String(pwdFldLogInPassword.getPassword());

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            lblProjectGCLogInError.setText("Please enter your username and password.");
        } // Check if username and password are incorrect
        else if (!username.equals("supra") || !password.equals("supra")) {
            lblProjectGCLogInError.setText("Username and password mismatch.");
        } // If credentials are correct, proceed to load the main screen
        else {
            lblProjectGCLogInError.setText(""); // Clear any previous error messages
            loadScreen("MainScreen"); // Load the main screen
        }
    }//GEN-LAST:event_bntLogInActionPerformed

    private void bntLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLogOutActionPerformed
        // TODO add your handling code here:
        pwdFldLogInPassword.setText("");
        txtFldLogInUsername.setText("");
        loadScreen("LogInScreen"); // Load the main screen
    }//GEN-LAST:event_bntLogOutActionPerformed

    private void txtFldSupportQueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldSupportQueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldSupportQueActionPerformed

    private void bntCartClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCartClearActionPerformed
        // TODO add your handling code here:
        clearTxtField();
    }//GEN-LAST:event_bntCartClearActionPerformed

    private void bntCartDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCartDeleteActionPerformed
        // TODO add your handling code here:
        String name = txtFldCartConsoleName.getText();
        deletedConsole(name);
    }//GEN-LAST:event_bntCartDeleteActionPerformed

    private void bntCartUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCartUpdateActionPerformed
        try {
            if (UpdateCart() == true) {
                JOptionPane.showMessageDialog(this, "Updated successfully!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid data!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bntCartUpdateActionPerformed

    private void txtFldCartQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldCartQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldCartQuantityActionPerformed

    private void bntDeviceVetailsClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeviceVetailsClearActionPerformed
        // TODO add your handling code here:
        txtFldDeviceDetailsConsoleName.setText("");
        txtFldDeviceDetailsBrand.setText("");
        txtFldDeviceDetailsQuantity.setText("");
        txtFldDeviceDetailsReleaseDate.setText("");
        txtFldDeviceDetailsSearch.setText("");
        JOptionPane.showMessageDialog(this, "All the fields are cleared!!", "Cleared", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bntDeviceVetailsClearActionPerformed

    private void bntDeviceDetailsAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeviceDetailsAddToCartActionPerformed
        try {
            if (addToCart() == true) {
                JOptionPane.showMessageDialog(this, "Added successfully!!", "Succuccfull", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid data!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bntDeviceDetailsAddToCartActionPerformed

    private void txtFldDeviceDetailsReleaseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldDeviceDetailsReleaseDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldDeviceDetailsReleaseDateActionPerformed

    private void txtFldDeviceDetailsConsoleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFldDeviceDetailsConsoleNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFldDeviceDetailsConsoleNameActionPerformed

    private void bntDeviceDetailsSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeviceDetailsSortByActionPerformed
        int SelectedComboBox = comboxDeviceDetailsSortBy.getSelectedIndex();
        if (SelectedComboBox == 1) {
            List<ProjectGConsole> sortedList = mergeSort.mergeSortByPrice(consoleDeviceDetailsList, false);
            addConsoleToDeviceDetailsTable(sortedList);
        } else if (SelectedComboBox == 2) {
            List<ProjectGConsole> sortedList = selectionSortByName.sortByName(consoleDeviceDetailsList, false);
            addConsoleToDeviceDetailsTable(sortedList);
        }
    }//GEN-LAST:event_bntDeviceDetailsSortByActionPerformed

    private void bntDeviceDetailsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeviceDetailsSearchActionPerformed
        // TODO add your handling code here:
        List<ProjectGConsole> sortedList = selectionSortByName.sortByName(consoleDeviceDetailsList, false);
        System.out.print("sorted");
        BinarySearch search = new BinarySearch();
        ProjectGConsole searchedData = search.searchByName(txtFldDeviceDetailsSearch.getText().trim(), sortedList, 0, sortedList.size() - 1);
        if (searchedData != null) {
            JOptionPane.showMessageDialog(this, "Data found ", "Found", JOptionPane.INFORMATION_MESSAGE);
            List<ProjectGConsole> SearchedList = new ArrayList<>();
            SearchedList.add(searchedData);
            addConsoleToDeviceDetailsTable(SearchedList);
        } else {
            JOptionPane.showMessageDialog(this, "Data not found ", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bntDeviceDetailsSearchActionPerformed

    private void bntDeviceDetailsRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeviceDetailsRefreshActionPerformed
        // TODO add your handling code here:
        addConsoleToDeviceDetailsTable(consoleDeviceDetailsList);
    }//GEN-LAST:event_bntDeviceDetailsRefreshActionPerformed

    private void bntCartOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCartOrderActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Product ordered!!", "Ordered", JOptionPane.INFORMATION_MESSAGE);
        addRemoConsoleToTable();
    }//GEN-LAST:event_bntCartOrderActionPerformed

    private void bntCartSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCartSortActionPerformed

        // Get the selected index of the ComboBox
        int SelectedComboBox = comboxCartSortBy.getSelectedIndex();

        if (SelectedComboBox == 1) { // Assuming 1 corresponds to "Sort by Quantity"
            List<ProjectGConsole> sortedList = insertionSort.sortByQuantity(consoleList, false);

            // Pass the sorted list to update the table
            addConsoleToTable(sortedList);
        }


    }//GEN-LAST:event_bntCartSortActionPerformed

// Method to set up the CardLayout and add panels
    public void initializeLayout() {
        cardLayout = new java.awt.CardLayout();
        getContentPane().setLayout(cardLayout);

        // Add panels with unique identifiers
        getContentPane().add(pnlLogInScreen, "LogInScreen");
        getContentPane().add(pnlMainScreen, "MainScreen");

        // Start with the login screen
        cardLayout.show(getContentPane(), "LogInScreen");
    }
    // Method to initialize data, including student list and table

    public void initializeData() {
        ProjectGConsole console1 = new ProjectGConsole("PS4", "playstation", "storage and performance", "extra fan", "YES", "9th Sept 1995", 10000);
        ProjectGConsole console2 = new ProjectGConsole("PS5", "playstation", "high performance", "extra fan and controller", "YES", "12th Nov 2020", 50000);
        ProjectGConsole console3 = new ProjectGConsole("Xbox Series X", "Xbox", "storage and performance", "extra fan", "YES", "10th Nov 2020", 9000);
        ProjectGConsole console4 = new ProjectGConsole("Xbox Series S", "xbox", "high storage", "extra fan and controller", "YES", "10th Nov 2020", 20000);
        ProjectGConsole console5 = new ProjectGConsole("Nintendo DS", "Nintendo", "performance", "portable", "YES", "21st Nov 1004", 1000);
        ProjectGConsole console6 = new ProjectGConsole("Nintendo Switch", "Nintendo", "performance", "portable", "YES", "3rd Mar 2017", 1500);
        consoleDeviceDetailsList.add(console1);
        consoleDeviceDetailsList.add(console2);
        consoleDeviceDetailsList.add(console3);
        consoleDeviceDetailsList.add(console4);
        consoleDeviceDetailsList.add(console5);
        consoleDeviceDetailsList.add(console6);

        addConsoleToDeviceDetailsTable(consoleDeviceDetailsList);
    }

    public void clearTxtField() {
        txtFldCartConsoleName.setText("");
        txtFldCartBrand.setText("");
        txtFldCartQuantity.setText("");
        txtFldCartReleaseDate.setText("");
        JOptionPane.showMessageDialog(this, "All the fields are cleared!!", "Cleared", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to switch s Binacreens
    public void loadScreen(String screenName) {
        cardLayout.show(getContentPane(), screenName);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(projectGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(projectGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(projectGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(projectGC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new projectGC().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCartClear;
    private javax.swing.JButton bntCartDelete;
    private javax.swing.JButton bntCartOrder;
    private javax.swing.JButton bntCartSort;
    private javax.swing.JButton bntCartUpdate;
    private javax.swing.JButton bntDeviceDetailsAddToCart;
    private javax.swing.JButton bntDeviceDetailsRefresh;
    private javax.swing.JButton bntDeviceDetailsSearch;
    private javax.swing.JButton bntDeviceDetailsSortBy;
    private javax.swing.JButton bntDeviceVetailsClear;
    private javax.swing.JButton bntLogIn;
    private javax.swing.JButton bntLogOut;
    private javax.swing.JButton bntSupportSubmit;
    private javax.swing.JComboBox<String> comboxCartSortBy;
    private javax.swing.JComboBox<String> comboxDeviceDetailsSortBy;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblCartBrand;
    private javax.swing.JLabel lblCartConsoleName;
    private javax.swing.JLabel lblCartQuantity;
    private javax.swing.JLabel lblCartReleaseDate;
    private javax.swing.JLabel lblCartSortBy;
    private javax.swing.JLabel lblDeviceDetails;
    private javax.swing.JLabel lblDeviceDetailsBrand;
    private javax.swing.JLabel lblDeviceDetailsConsoleName;
    private javax.swing.JLabel lblDeviceDetailsQuantity;
    private javax.swing.JLabel lblDeviceDetailsReleaseDate;
    private javax.swing.JLabel lblDeviceDetailsSearch;
    private javax.swing.JLabel lblDeviceDetailsSortBy;
    private javax.swing.JLabel lblLogInTitle;
    private javax.swing.JLabel lblLogInTxt2;
    private javax.swing.JLabel lblLogInTxt3;
    private javax.swing.JLabel lblLoginTxt;
    private javax.swing.JLabel lblMainTitle;
    private javax.swing.JLabel lblProjectGCLogInError;
    private javax.swing.JLabel lblProjectGCLogo;
    private javax.swing.JLabel lblProjectGCTitle;
    private javax.swing.JLabel lblProjectGCTxt;
    private javax.swing.JLabel lblProjectGCTxt2;
    private javax.swing.JLabel lblProjectGCTxt3;
    private javax.swing.JLabel lblSupportTxt;
    private javax.swing.JPanel pnlCart;
    private javax.swing.JPanel pnlDevices;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLogInBox;
    private javax.swing.JPanel pnlLogInScreen;
    private javax.swing.JPanel pnlLogoTitleSection;
    private javax.swing.JPanel pnlMainScreen;
    private javax.swing.JPanel pnlSupport;
    private javax.swing.JPasswordField pwdFldLogInPassword;
    private javax.swing.JScrollPane scrlPnlCart;
    private javax.swing.JScrollPane scrlPnlDeviceDetails;
    private javax.swing.JTabbedPane tabPnlMain;
    private javax.swing.JTable tblCartDetails;
    private javax.swing.JTable tblDeviceContent;
    private javax.swing.JTextArea txtAreaWelcometext;
    private javax.swing.JTextField txtFldCartBrand;
    private javax.swing.JTextField txtFldCartConsoleName;
    private javax.swing.JTextField txtFldCartQuantity;
    private javax.swing.JTextField txtFldCartReleaseDate;
    private javax.swing.JTextField txtFldDeviceDetailsBrand;
    private javax.swing.JTextField txtFldDeviceDetailsConsoleName;
    private javax.swing.JTextField txtFldDeviceDetailsQuantity;
    private javax.swing.JTextField txtFldDeviceDetailsReleaseDate;
    private javax.swing.JTextField txtFldDeviceDetailsSearch;
    private javax.swing.JTextField txtFldLogInUsername;
    private javax.swing.JTextField txtFldSupportQue;
    // End of variables declaration//GEN-END:variables

}
