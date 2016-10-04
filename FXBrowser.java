package FXBrowser;  
 import com.sun.javafx.collections.MappingChange.Map;  
import java.util.HashMap;
 import javafx.application.Application;  
 import javafx.beans.binding.Bindings;  
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
 import javafx.beans.value.ChangeListener;  
import javafx.beans.value.ObservableStringValue;
 import javafx.beans.value.ObservableValue;  
 import javafx.collections.ObservableList;  
 import javafx.event.ActionEvent;  
 import javafx.event.EventHandler;  
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
 import javafx.geometry.Side;  
 import javafx.scene.Group;  
import javafx.scene.Node;
import javafx.scene.Parent;
 import javafx.scene.Scene;  
 import javafx.scene.control.Button;  
import javafx.scene.control.ContentDisplay;
 import javafx.scene.control.Label;  
import javafx.scene.control.Menu;
 import javafx.scene.control.MenuBar;
 import javafx.scene.control.MenuItem;  
import javafx.scene.control.SeparatorMenuItem;  
import javafx.scene.control.Tab;  
import javafx.scene.control.TabPane;  
import javafx.scene.control.TextField;  
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
 import javafx.scene.image.Image;  
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
 import javafx.scene.layout.BorderPane;  
import javafx.scene.layout.GridPane;
 import javafx.scene.layout.HBox;  
 import javafx.scene.layout.Priority;  
 import javafx.scene.layout.VBox;  
import javafx.scene.shape.PolygonBuilder;
 import javafx.scene.text.Font;  
 import javafx.scene.text.FontWeight;  
 import javafx.scene.web.WebEngine;  
 import javafx.scene.web.WebHistory;  
import javafx.scene.web.WebView;  
import javafx.stage.Stage;

 public class FXBrowser extends Application{  
      //The default URL.  
      public static final String DEFAULT_URL = "http://google.com/";
      final TabPane tabPane = new TabPane();
      String Text="";
      String title="";
      Group root = new Group();  
      VirtualKeyboard vkb=new VirtualKeyboard();
      //Scene scene2=new Scene((Parent) vkb.view());
      
      

                            
                            
                            
                           
      
      
      
      
      //For initialization of Browser front end stage.  
      @Override  
      public void start(Stage primaryStage) throws Exception {  
          primaryStage.setTitle(" Web Browser ");
          login(primaryStage);
          init(primaryStage);
           primaryStage.show();  
      }  
      

          private void login(Stage primaryStage) {
             // BorderPane login_borderPane
          }

    



    //Custom function for creation of New Tabs.
      
      private Tab createAndSelectNewTab(final TabPane tabPane, final String title) {  
           Tab tab = new Tab(title);  
           Label aboutLabel = new Label();  
           aboutLabel.setText("\n\n\n\n\t\t\tWelcome to JavaFX Custom Browser. " +  
                     "\n\t\t\tThis is a custom web browser for our college project " +  
                     "\n\t\t\tTo start browsing, click on New Tab.");  
           aboutLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 20));  
           
//           HBox hb=new HBox();
//           VirtualKeyboard vkb = new VirtualKeyboard();
//           hb.getChildren().add(vkb.view());
           
           tab.setContent(aboutLabel);  
           final ObservableList<Tab> tabs = tabPane.getTabs();  
           tab.closableProperty().bind(Bindings.size(tabs).greaterThan(2));  
           tabs.add(tabs.size() - 1, tab);  
           tabPane.getSelectionModel().select(tab);  
           return tab;  
      }  
      
      
      //Initialization function of the program.  
      private void init(Stage primaryStage) { 
         //VirtualKeyboard vkb = new VirtualKeyboard();
           //primaryStage.setTitle(" Web Browser "); 
          //Image mIcon=new Image(getClass().getResourceAsStream("wow.jpg"));
           //primaryStage.getIcons().add(mIcon);
           //Group root = new Group(); 
          Scene scene =new Scene(root);
           primaryStage.setScene(scene);  
           //To enable Full Screen mode - By Default.  
           primaryStage.setFullScreen(true);  
           //BorderPane borderPane = new BorderPane();  
           //final TabPane tabPane = new TabPane();  
           //Preferred Size of TabPane.  
           GridPane gridpane =new GridPane();
           
           tabPane.setPrefSize(1366, 760);  
           //Placement of TabPane.  
           tabPane.setSide(Side.TOP);  
           /* To disable closing of tabs.  
            * tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);*/  
           final Tab newtab = new Tab();  
           newtab.setText("  +  "); 
           newtab.setClosable(false);  
           //Addition of New Tab to the tabpane.  
           tabPane.getTabs().addAll(newtab);  
           createAndSelectNewTab(tabPane, "    Welcome    ");  
           //Function to add and display new tabs with default URL display.
           //getSelectionModel() -- Gets the model used for tab selection.
           //selectedItemProperty() -- Refers to the selected item property, which is used to indicate the currently selected item in the selection model.
           tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {  
                @Override  
                public void changed(ObservableValue<? extends Tab> observable,  
                          Tab oldSelectedTab, Tab newSelectedTab) {  
                     if (newSelectedTab == newtab) {  
                     
                         Tab tab1=newTabs();
                         
                         final ObservableList<Tab> tabs = tabPane.getTabs();
                         //BooleanProperty closableProperty() ---The closable state for this tab.
                          tab1.closableProperty().bind(Bindings.size(tabs).greaterThan(2));  
                          tabs.add(tabs.size() - 1, tab1);  
                          tabPane.getSelectionModel().select(tab1);
                         
                          
                     }  
                }  
           });
           
           gridpane.add(tabPane, 1, 1);
           //borderPane.setCenter(tabPane);
           root.getChildren().addAll(gridpane);  
      }
      
      public Tab newTabs(){
      
      Tab tab = new Tab();
                          Button forward=new Button(" >> ");
                          Button backward=new Button(" << ");
                          Button refresh =new Button("  ");
                          Button Menu=new Button(" MENU ");
                                MenuBar menuBar = new MenuBar();
                          Menu fileMenu = new Menu(" Menu");
                            MenuItem newMenuItem = new MenuItem(" New Tab ");
                            MenuItem vkbMenuItem = new MenuItem(" Virtual Keyboard ");
                            MenuItem saveMenuItem = new MenuItem(" History ");
                            MenuItem BookMenuItem = new MenuItem(" Bookmark ");
                            MenuItem helpMenuItem = new MenuItem(" Help ");
                            MenuItem aboutMenuItem = new MenuItem(" About ");
                            MenuItem exitMenuItem = new MenuItem(" Exit ");
                          fileMenu.getItems().addAll(newMenuItem,vkbMenuItem, saveMenuItem,BookMenuItem,new SeparatorMenuItem(),helpMenuItem,aboutMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
                            menuBar.getMenus().add(fileMenu);

                          
                          tab.setText("    New Tab        ");  
                          //WebView - to display, browse web pages.  
                          WebView webView = new WebView();  
                          final WebEngine webEngine = webView.getEngine();
                          webEngine.setJavaScriptEnabled(true);
                          
                          //for history
                          WebHistory history = webEngine.getHistory();
                          
                          //webEngine.load(DEFAULT_URL);  
                          final TextField urlField = new TextField(DEFAULT_URL);  
                          webEngine.locationProperty().addListener(new ChangeListener<String>() {  
                               @Override public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {  
                                    urlField.setText(newValue);  
                               }  
                          });
                          
                          
                          webEngine.titleProperty().addListener(new ChangeListener<String>(){

          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              tab.setText(newValue);
              title=newValue;
          }
                          
                          });
                          
                         /* //Action definition for the Button Go.  
                          EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {  
                               @Override public void handle(ActionEvent event) {  
                                    webEngine.load(urlField.getText().startsWith("http://")   
                                              ? urlField.getText()   
                                                        : "http://" + urlField.getText());
                                    Text=urlField.getText().startsWith("http://")   
                                              ? urlField.getText()   
                                                        : "http://" + urlField.getText();
                                    tHistory(Text,title);
                                    
                               }  

          
                          };
                          
                          */
                          //
                          EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {  
                               @Override public void handle(ActionEvent event) { 
                                  if(urlField.getText().startsWith("http://")){
                                  
                                      webEngine.load(urlField.getText());
                                  } else if(urlField.getText().startsWith("https://")){
                                      webEngine.load(urlField.getText());
                                      
                                  } else{
                                      webEngine.load("http://" + urlField.getText());
                                  
                                  }
                               }};
                          
                        //for per page forward and back options
                          
                          forward.setOnAction(new EventHandler<ActionEvent>(){

                              @Override
                              public void handle(ActionEvent event) {
                              webEngine.executeScript("history.forward()");
                              
                              }
                          
                          });
                          
                          backward.setOnAction(new EventHandler<ActionEvent>(){

                              @Override
                              public void handle(ActionEvent event) {
                              webEngine.executeScript("history.back()");
                              
                              }
                          
                          });
                          
                          
                          refresh.setOnAction(new EventHandler<ActionEvent>(){

                              @Override
                              public void handle(ActionEvent event) {
                              webEngine.reload();
                              
                              }
                          
                          });
                          
                          
                          /// Actions for Menus
                          newMenuItem.setOnAction(new EventHandler<ActionEvent>(){

          @Override
          public void handle(ActionEvent event) {
              Tab tab1=newTabs();
              final ObservableList<Tab> tabs = tabPane.getTabs();  
                          tab1.closableProperty().bind(Bindings.size(tabs).greaterThan(2));  
                          tabs.add(tabs.size() - 1, tab1);  
                          tabPane.getSelectionModel().select(tab1);
          }
                          
                          });
                          
//                          vkbMenuItem.setOnAction(new EventHandler<ActionEvent>(){
//
//          @Override
//          public void handle(ActionEvent t) {
//              
//             
//             tab.setContent(vkb.view());
//          }
//      });
                          
                          
                          
                          
                          urlField.setOnAction(goAction);  
                          Button goButton = new Button("   Search   ");  
                          goButton.setDefaultButton(true);  
                          goButton.setOnAction(goAction);  
                          // Layout logic  
                          HBox hBox = new HBox(5);  
                          hBox.getChildren().addAll(menuBar,backward,refresh,forward,urlField, goButton);  
                          HBox.setHgrow(urlField, Priority.ALWAYS);  
                          final VBox vBox = new VBox(5);  
                          vBox.getChildren().setAll(hBox, webView);  
                          VBox.setVgrow(webView, Priority.ALWAYS);

          
                          
        vkbMenuItem.setOnAction(new EventHandler<ActionEvent>(){

          @Override
          public void handle(ActionEvent t) {
              
             vBox.getChildren().add(vkb.view());
             
             //tab.setContent(vkb.view());
          }
      });
                          tab.setContent(vBox);  
                          
                          return tab;
      
      }
                        //// History Function
      
      java.util.Map<String,String> map=new HashMap<String,String>();
      public void tHistory(String Text, String title) {
          map.put(Text,title);                  
                        }
      //show history
      public void sHistory(){
          Scene hScene=new Scene(root,600,600);
          for( String key : map.keySet()) {
    System.out.println("Key " + key +"; Value " + map.get(key));
}
      
      }
      
      //to click on history address
    public void clickonHistory(String addrs){
    String resultString = map.get(addrs);
    newTabs(resultString);
    
    }
      
      
      
      public static void main(String args[]){  
           launch(args);  
      }  

    public void newTabs(String resultString) {
           Tab tab = new Tab();
                          Button forward=new Button(" >> ");
                          Button backward=new Button(" << ");
                          Button refresh =new Button("  ");
                          Button Menu=new Button(" MENU ");
                                MenuBar menuBar = new MenuBar();
                          Menu fileMenu = new Menu(" Menu");
                            MenuItem newMenuItem = new MenuItem(" New Tab ");
                            MenuItem saveMenuItem = new MenuItem(" History ");
                            MenuItem BookMenuItem = new MenuItem(" Bookmark ");
                            MenuItem helpMenuItem = new MenuItem(" Help ");
                            MenuItem aboutMenuItem = new MenuItem(" About ");
                            MenuItem exitMenuItem = new MenuItem(" Exit ");
                          fileMenu.getItems().addAll(newMenuItem, saveMenuItem,BookMenuItem,new SeparatorMenuItem(),helpMenuItem,aboutMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
                            menuBar.getMenus().add(fileMenu);

                          
                          tab.setText("    New Tab        ");  
                          //WebView - to display, browse web pages.  
                          WebView webView = new WebView();  
                          final WebEngine webEngine = webView.getEngine();
                          webEngine.setJavaScriptEnabled(true);
                          
                          //for history
                          WebHistory history = webEngine.getHistory();
                          
                          //webEngine.load(DEFAULT_URL);  
                          final TextField urlField = new TextField(resultString);  
                          webEngine.locationProperty().addListener(new ChangeListener<String>() {  
                               @Override public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {  
                                    urlField.setText(newValue);  
                               }  
                          });
                          
                          webEngine.titleProperty().addListener(new ChangeListener<String>(){

          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              tab.setText(newValue);
              title=newValue;
          }
                          
                          });
                          
                          //Action definition for the Button Go.  
                          EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {  
                               @Override public void handle(ActionEvent event) {  
                                    webEngine.load(urlField.getText().startsWith("http://")   
                                              ? urlField.getText()   
                                                        : "http://" + urlField.getText());
                                    Text=urlField.getText().startsWith("http://")   
                                              ? urlField.getText()   
                                                        : "http://" + urlField.getText();
                                    tHistory(Text,title);
                                    
                               }  

          
                          };
                          
                          
                          //for per page forward and back options
                          
                          forward.setOnAction(new EventHandler<ActionEvent>(){

                              @Override
                              public void handle(ActionEvent event) {
                              webEngine.executeScript("history.forward()");
                              
                              }
                          
                          });
                          
                          backward.setOnAction(new EventHandler<ActionEvent>(){

                              @Override
                              public void handle(ActionEvent event) {
                              webEngine.executeScript("history.back()");
                              
                              }
                          
                          });
                          
                          
                          refresh.setOnAction(new EventHandler<ActionEvent>(){

                              @Override
                              public void handle(ActionEvent event) {
                              webEngine.reload();
                              
                              }
                          
                          });
                          
                          
                          /// Actions for Menus
                          newMenuItem.setOnAction(new EventHandler<ActionEvent>(){

          @Override
          public void handle(ActionEvent event) {
              Tab tab1=newTabs();
              final ObservableList<Tab> tabs = tabPane.getTabs();  
                          tab1.closableProperty().bind(Bindings.size(tabs).greaterThan(2));  
                          tabs.add(tabs.size() - 1, tab1);  
                          tabPane.getSelectionModel().select(tab1);
          }
                          
                          });
                          
                          
                          
                          
                          urlField.setOnAction(goAction);  
                          Button goButton = new Button("   Search   ");  
                          goButton.setDefaultButton(true);  
                          goButton.setOnAction(goAction);  
                          // Layout logic  
                          HBox hBox = new HBox(5);  
                          hBox.getChildren().addAll(menuBar,backward,refresh,forward,urlField, goButton);  
                          HBox.setHgrow(urlField, Priority.ALWAYS);  
                          final VBox vBox = new VBox(5);  
                          vBox.getChildren().setAll(hBox, webView);  
                          VBox.setVgrow(webView, Priority.ALWAYS);  
                          tab.setContent(vBox);
//                          final ObservableList<Tab> tabs = tabPane.getTabs();  
//                          tab.closableProperty().bind(Bindings.size(tabs).greaterThan(2));  
//                          tabs.add(tabs.size() - 1, tab);  
//                          tabPane.getSelectionModel().select(tab);
                          
                          //return tab;   
    }


 }



class VirtualKeyboard {
  private final VBox root ;
  
  
  /**
   * Creates a Virtual Keyboard. 
   * @param target The node that will receive KeyEvents from this keyboard. 
   * If target is null, KeyEvents will be dynamically forwarded to the focus owner
   * in the Scene containing this keyboard.
   */
  public VirtualKeyboard(ReadOnlyObjectProperty<Node> target) {
    this.root = new VBox(5);
    root.setPadding(new Insets(10));
    root.getStyleClass().add("virtual-keyboard");

    final Modifiers modifiers = new Modifiers();

    // Data for regular buttons; split into rows
    final String[][] unshifted = new String[][] {
        { "`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=" },
        { "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "\\" },
        { "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'" },
        { "z", "x", "c", "v", "b", "n", "m", ",", ".", "/" } };

    final String[][] shifted = new String[][] {
        { "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+" },
        { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "{", "}", "|" },
        { "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"" },
        { "Z", "X", "C", "V", "B", "N", "M", "<", ">", "?" } };

    final KeyCode[][] codes = new KeyCode[][] {
        { KeyCode.BACK_QUOTE, KeyCode.DIGIT1, KeyCode.DIGIT2, KeyCode.DIGIT3,
            KeyCode.DIGIT4, KeyCode.DIGIT5, KeyCode.DIGIT6, KeyCode.DIGIT7,
            KeyCode.DIGIT8, KeyCode.DIGIT9, KeyCode.DIGIT0, KeyCode.SUBTRACT,
            KeyCode.EQUALS },
        { KeyCode.Q, KeyCode.W, KeyCode.E, KeyCode.R, KeyCode.T, KeyCode.Y,
            KeyCode.U, KeyCode.I, KeyCode.O, KeyCode.P, KeyCode.OPEN_BRACKET,
            KeyCode.CLOSE_BRACKET, KeyCode.BACK_SLASH },
        { KeyCode.A, KeyCode.S, KeyCode.D, KeyCode.F, KeyCode.G, KeyCode.H,
            KeyCode.J, KeyCode.K, KeyCode.L, KeyCode.SEMICOLON, KeyCode.QUOTE },
        { KeyCode.Z, KeyCode.X, KeyCode.C, KeyCode.V, KeyCode.B, KeyCode.N,
            KeyCode.M, KeyCode.COMMA, KeyCode.PERIOD, KeyCode.SLASH } };

    // non-regular buttons (don't respond to Shift)
    final Button escape = createNonshiftableButton("Esc", KeyCode.ESCAPE, modifiers, target);
    final Button backspace = createNonshiftableButton("Backspace", KeyCode.BACK_SPACE, modifiers, target);
    final Button delete = createNonshiftableButton("Del", KeyCode.DELETE, modifiers, target);
    final Button enter = createNonshiftableButton("Enter", KeyCode.ENTER,  modifiers, target);
    final Button tab = createNonshiftableButton("Tab", KeyCode.TAB, modifiers, target);

    // Cursor keys, with graphic instead of text
    final Button cursorLeft = createCursorKey(KeyCode.LEFT, modifiers, target, 15.0, 5.0, 15.0, 15.0, 5.0, 10.0);
    final Button cursorRight = createCursorKey(KeyCode.RIGHT, modifiers, target, 5.0, 5.0, 5.0, 15.0, 15.0, 10.0);
    final Button cursorUp = createCursorKey(KeyCode.UP, modifiers, target, 10.0, 0.0, 15.0, 10.0, 5.0, 10.0);
    final Button cursorDown = createCursorKey(KeyCode.DOWN, modifiers, target, 10.0, 10.0, 15.0, 0.0, 5.0, 0.0);
    final VBox cursorUpDown = new VBox(2);
    cursorUpDown.getChildren().addAll(cursorUp, cursorDown);

    // "Extras" to go at the left or right end of each row of buttons.
    final Node[][] extraLeftButtons = new Node[][] { {escape}, {tab}, {modifiers.capsLockKey()}, {modifiers.shiftKey()} };
    final Node[][] extraRightButtons = new Node[][] { {backspace}, {delete}, {enter}, {modifiers.secondShiftKey()} };

    // build layout
    for (int row = 0; row < unshifted.length; row++) {
      HBox hbox = new HBox(5);
      hbox.setAlignment(Pos.CENTER);
      root.getChildren().add(hbox);

      hbox.getChildren().addAll(extraLeftButtons[row]);
      for (int k = 0; k < unshifted[row].length; k++) {
        hbox.getChildren().add( createShiftableButton(unshifted[row][k], shifted[row][k], codes[row][k], modifiers, target));
      }
      hbox.getChildren().addAll(extraRightButtons[row]);
    }

    final Button spaceBar = createNonshiftableButton(" ", KeyCode.SPACE, modifiers, target);
    spaceBar.setMaxWidth(Double.POSITIVE_INFINITY);
    HBox.setHgrow(spaceBar, Priority.ALWAYS);

    final HBox bottomRow = new HBox(5);
    bottomRow.setAlignment(Pos.CENTER);
    bottomRow.getChildren().addAll(modifiers.ctrlKey(), modifiers.altKey(),
        modifiers.metaKey(), spaceBar, cursorLeft, cursorUpDown, cursorRight);
    root.getChildren().add(bottomRow);    
  }
  
  /**
   * Creates a VirtualKeyboard which uses the focusProperty of the scene to which it is attached as its target
   */
  public VirtualKeyboard() {
    this(null);
  }
  
  /**
   * Visual component displaying this keyboard. The returned node has a style class of "virtual-keyboard".
   * Buttons in the view have a style class of "virtual-keyboard-button".
   * @return a view of the keyboard.
   */
  public Node view() {
    return root ;
  }
  
  // Creates a "regular" button that has an unshifted and shifted value
  private Button createShiftableButton(final String unshifted, final String shifted,
      final KeyCode code, Modifiers modifiers, final ReadOnlyObjectProperty<Node> target) {
    final ReadOnlyBooleanProperty letter = new SimpleBooleanProperty( unshifted.length() == 1 && Character.isLetter(unshifted.charAt(0)));
    final StringBinding text = 
        Bindings.when(modifiers.shiftDown().or(modifiers.capsLockOn().and(letter)))
        .then(shifted)
        .otherwise(unshifted);
    Button button = createButton(text, code, modifiers, target);
    return button;
  }

  // Creates a button with fixed text not responding to Shift
  private Button createNonshiftableButton(final String text, final KeyCode code, final Modifiers modifiers, final ReadOnlyObjectProperty<Node> target) {
    StringProperty textProperty = new SimpleStringProperty(text);
    Button button = createButton(textProperty, code, modifiers, target);
    return button;
  }
  
  // Creates a button with mutable text, and registers listener with it
  private Button createButton(final ObservableStringValue text, final KeyCode code, final Modifiers modifiers, final ReadOnlyObjectProperty<Node> target) {
    final Button button = new Button();
    button.textProperty().bind(text);
        
    // Important not to grab the focus from the target:
    button.setFocusTraversable(false);
    
    // Add a style class for css:
    button.getStyleClass().add("virtual-keyboard-button");
    
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {

        final Node targetNode ;
        if (target != null) {
          targetNode = target.get();
        } else {
          targetNode = view().getScene().getFocusOwner();
        }
        
        if (targetNode != null) {
          final String character;
          if (text.get().length() == 1) {
            character = text.get();
          } else {
            character = KeyEvent.CHAR_UNDEFINED;
          }
          final KeyEvent keyPressEvent = createKeyEvent(button, targetNode, KeyEvent.KEY_PRESSED, character, code, modifiers);
          targetNode.fireEvent(keyPressEvent);
          final KeyEvent keyReleasedEvent = createKeyEvent(button, targetNode, KeyEvent.KEY_RELEASED, character, code, modifiers);
          targetNode.fireEvent(keyReleasedEvent);
          if (character != KeyEvent.CHAR_UNDEFINED) {
            final KeyEvent keyTypedEvent = createKeyEvent(button, targetNode, KeyEvent.KEY_TYPED, character, code, modifiers);
            targetNode.fireEvent(keyTypedEvent);
          }
          modifiers.releaseKeys();
        }
      }
    });
    return button;
  }

  // Utility method to create a KeyEvent from the Modifiers
  private KeyEvent createKeyEvent(Object source, EventTarget target,
      EventType<KeyEvent> eventType, String character, KeyCode code,
      Modifiers modifiers) {
    return new KeyEvent(source, target, eventType, character, code.toString(),
        code, modifiers.shiftDown().get(), modifiers.ctrlDown().get(),
        modifiers.altDown().get(), modifiers.metaDown().get());
  }
  
  // Utility method for creating cursor keys:
  private Button createCursorKey(KeyCode code, Modifiers modifiers, ReadOnlyObjectProperty<Node> target, Double... points) {
    Button button = createNonshiftableButton("", code, modifiers, target);
    final Node graphic = PolygonBuilder.create().points(points).build();
    graphic.setStyle("-fx-fill: -fx-mark-color;");
    button.setGraphic(graphic);
    button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    return button ;
  }
  
  // Convenience class to bundle together the modifier keys and their selected state
  private static class Modifiers {
    private final ToggleButton shift;
    private final ToggleButton shift2;
    private final ToggleButton ctrl;
    private final ToggleButton alt;
    private final ToggleButton meta;
    private final ToggleButton capsLock;

    Modifiers() {
      this.shift = createToggle("Shift");
      this.shift2 = createToggle("Shift");
      this.ctrl = createToggle("Ctrl");
      this.alt = createToggle("Alt");
      this.meta = createToggle("Meta");
      this.capsLock = createToggle("Caps");

      shift2.selectedProperty().bindBidirectional(shift.selectedProperty());
    }

    private ToggleButton createToggle(final String text) {
      final ToggleButton tb = new ToggleButton(text);
      tb.setFocusTraversable(false);
      return tb;
    }

    public Node shiftKey() {
      return shift;
    }

    public Node secondShiftKey() {
      return shift2;
    }

    public Node ctrlKey() {
      return ctrl;
    }

    public Node altKey() {
      return alt;
    }

    public Node metaKey() {
      return meta;
    }

    public Node capsLockKey() {
      return capsLock;
    }

    public BooleanProperty shiftDown() {
      return shift.selectedProperty();
    }

    public BooleanProperty ctrlDown() {
      return ctrl.selectedProperty();
    }

    public BooleanProperty altDown() {
      return alt.selectedProperty();
    }

    public BooleanProperty metaDown() {
      return meta.selectedProperty();
    }

    public BooleanProperty capsLockOn() {
      return capsLock.selectedProperty();
    }

    public void releaseKeys() {
      shift.setSelected(false);
      ctrl.setSelected(false);
      alt.setSelected(false);
      meta.setSelected(false);
    }
  }  
}

