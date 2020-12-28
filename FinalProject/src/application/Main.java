package application;
	
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	//@Override
	double FPS = 150;
	Pane root;
	public Stage stage;
	private Timeline gameLoop,gameLoop2;
	private int thinktime = 30;
	private Scene game,menu,intromode,professionintro,chooseprofession;
	private Button start,intro,exit,backtomenu,gotoprofessionintro,backtointro,war,gua,thi,eng,ran,ele,nec,mes,endturn;
	private VBox vb;
	ImageView backgroundpic,warpic,ranpic,thipic,guapic,elepic,engpic,necpic,mespic,warpic2,ranpic2,elepic2,thipic2,guapic2,engpic2,mespic2,necpic2,warriorheropowersmall,
	warriorheropowerbig,shield1,shield2,manapic,manapic2,shieldblock,BloodWarrior,ArcingSlice,Zhatian,undeadarmysmall,undeadarmybig,hibernating,dragonflame,undeadarmybig2,augury,augurysmall,augurybig;
	private Label player1,player2,playerwon,zhatianwon;
	private Text Time,Player,Player1HP,Player2HP,armornumber1,armornumber2,mana,mana2,attack,endu;
	MediaPlayer gw2,wow,button,sword;
	ImageView warrior1;
	Image warrior = new Image(Main.class.getResourceAsStream("warrior.png"));
	Image guardian = new Image(Main.class.getResourceAsStream("guardian.png"));
	Image thief = new Image(Main.class.getResourceAsStream("thief.png"));
	Image engineer = new Image(Main.class.getResourceAsStream("engineer.png"));
	Image ranger = new Image(Main.class.getResourceAsStream("ranger.png"));
	Image elementalist = new Image(Main.class.getResourceAsStream("elementalist.png"));
	Image necromancer = new Image(Main.class.getResourceAsStream("¦ºÆF.png"));
	Image mesmer = new Image(Main.class.getResourceAsStream("mesmer.png"));
	Image waricon = new Image(Main.class.getResourceAsStream("waricon.png"));
	Image guaicon = new Image(Main.class.getResourceAsStream("guaicon.png"));
	Image thiicon = new Image(Main.class.getResourceAsStream("thiicon.png"));
	Image engicon = new Image(Main.class.getResourceAsStream("engicon.png"));
	Image ranicon = new Image(Main.class.getResourceAsStream("ranicon.png"));
	Image eleicon = new Image(Main.class.getResourceAsStream("eleicon.png"));
	Image necicon = new Image(Main.class.getResourceAsStream("necicon.png"));
	Image mesicon = new Image(Main.class.getResourceAsStream("mesicon.png"));
	Image background = new Image(Main.class.getResourceAsStream("table.png"));
	Media Gw2 = new Media(getClass().getResource("GW2 Living World Soundtrack - Lions Arch Reborn (Live).mp3").toString()); 
	Media Wow = new Media(getClass().getResource("WoW TavernInn Music Collection.mp3").toString()); 
	Media click = new Media(getClass().getResource("Click button (16 sound effects).mp3").toString());
	Media Sword = new Media(getClass().getResource("swing2.mp3").toString());
	int b = 0,count = 0,timer = 0,timer2 = 0,a = 0,k1 = 0,k2 = 0,armor1 = 0,armor2,HP1=30,HP2 = 30,mananumber = 1,mananumber2 = 1,manaturn = 1,counter = 0,turn = 0,endure = 3,weapon = 0,attacknumber = 5,endurenumber = 3;
	
	boolean gameover = false;
	public void start(Stage primaryStage) {
		stage = primaryStage;
		root = new Pane();  
    	root.setStyle("-fx-background-color:#000000");

		try {
			while(gameover = false) {
				
			}
			gw2= new MediaPlayer(Gw2);
			gw2.play();
			wow = new MediaPlayer(Wow);
			button = new MediaPlayer(click);
			sword = new MediaPlayer(Sword);
			root = new Pane();  
	    	root.setStyle("-fx-background-color:#000000");
			//Time = (Text) game.lookup("#Time");
	        Player = new Text("Player's turn");
			Player.setFill(Color.WHITE);
	    	Player.setFont(Font.font(null, FontWeight.BOLD, 35));
	    	Player.setTranslateX(150);
	        Player.setTranslateY(445);
	        Player2HP = new Text(""+HP2);
			Player2HP.setFill(Color.RED);
	    	Player2HP.setFont(Font.font(null, FontWeight.BOLD, 43));
	    	Player2HP.setTranslateX(770);
	        Player2HP.setTranslateY(310);
	        Player1HP = new Text(""+HP1);
			Player1HP.setFill(Color.RED);
	    	Player1HP.setFont(Font.font(null, FontWeight.BOLD, 43));
	    	Player1HP.setTranslateX(760);
	        Player1HP.setTranslateY(900);
	        armornumber1 = new Text(""+armor1);
			armornumber1.setFill(Color.WHITE);
	    	armornumber1.setFont(Font.font(null, FontWeight.BOLD, 40));
	    	armornumber1.setTranslateX(770);
	        armornumber1.setTranslateY(850);
	        Time = new Text("Time:"+thinktime);
	        Time.setFill(Color.WHITE);
			Time.setFont(Font.font(null, FontWeight.BOLD, 40));
	    	Time.setTranslateX(170);
	        Time.setTranslateY(500);
	        mana = new Text(""+mananumber);
			mana.setFill(Color.WHITE);
			mana.setFont(Font.font(null, FontWeight.BOLD, 45));
	    	mana.setTranslateX(1150);
	        mana.setTranslateY(890);
	        mana2 = new Text(""+mananumber2);
			mana2.setFill(Color.WHITE);
			mana2.setFont(Font.font(null, FontWeight.BOLD, 45));
	    	mana2.setTranslateX(1100);
	        mana2.setTranslateY(100);
	        attack = new Text(""+attacknumber);
			attack.setFill(Color.WHITE);
			attack.setFont(Font.font(null, FontWeight.BOLD, 45));
	    	attack.setTranslateX(500);
	        attack.setTranslateY(900);
	        endu = new Text(""+endurenumber);
			endu.setFill(Color.WHITE);
			endu.setFont(Font.font(null, FontWeight.BOLD, 45));
	    	endu.setTranslateX(550);
	        endu.setTranslateY(900);
			menu  = new Scene(FXMLLoader.load(getClass().getResource("menu.fxml")));
			intromode  = new Scene(FXMLLoader.load(getClass().getResource("intromode.fxml")));
			game = new Scene(FXMLLoader.load(getClass().getResource("background.fxml")));
			Pane p1 = (Pane)(game.getRoot());
			p1.getChildren().add(Time);
			Pane p2 = (Pane)(game.getRoot());
			p2.getChildren().add(Player);
			Pane p3 = (Pane)(game.getRoot());
			p3.getChildren().add(Player1HP);
			Pane p4 = (Pane)(game.getRoot());
			p4.getChildren().add(Player2HP);
			Pane p5 = (Pane)(game.getRoot());
			p5.getChildren().add(armornumber1);
			Pane p6 = (Pane)(game.getRoot());
			p6.getChildren().add(mana2);
			Pane p7 = (Pane)(game.getRoot());
			p7.getChildren().add(mana);
			Pane p8 = (Pane)(game.getRoot());
			p8.getChildren().add(attack);
			Pane p9 = (Pane)(game.getRoot());
			p9.getChildren().add(endu);
			professionintro = new Scene(FXMLLoader.load(getClass().getResource("professionintro.fxml")));
			chooseprofession = new Scene(FXMLLoader.load(getClass().getResource("chooseprofession.fxml")));
			start = (Button) menu.lookup("#start");
			intro = (Button) menu.lookup("#intro");
			exit = (Button) menu.lookup("#exit");
			backtointro = (Button) professionintro.lookup("#backtointro");
			gotoprofessionintro = (Button) intromode.lookup("#gotoprofessionintro");	
			backtomenu = (Button) intromode.lookup("#backtomenu");
			war = (Button) chooseprofession.lookup("#war");
			gua = (Button) chooseprofession.lookup("#gua");
			thi = (Button) chooseprofession.lookup("#thi");
			eng = (Button) chooseprofession.lookup("#eng");
			ran = (Button) chooseprofession.lookup("#ran");
			ele = (Button) chooseprofession.lookup("#ele");
			nec = (Button) chooseprofession.lookup("#nec");
			mes = (Button) chooseprofession.lookup("#mes");
			endturn = (Button) game.lookup("#endturn");
			player1 = (Label) chooseprofession.lookup("#player1");
			playerwon = (Label) game.lookup("#playerwon");
			zhatianwon = (Label) game.lookup("#zhatianwon");
			warpic = (ImageView) game.lookup("#warpic");
	    	
			guapic = (ImageView) game.lookup("#guapic");
			thipic = (ImageView) game.lookup("#thipic");
			engpic = (ImageView) game.lookup("#engpic");
			ranpic = (ImageView) game.lookup("#ranpic");
			elepic = (ImageView) game.lookup("#elepic");
			necpic = (ImageView) game.lookup("#necpic");
			mespic = (ImageView) game.lookup("#mespic");
			augury = (ImageView) game.lookup("#augury");
			augurysmall = (ImageView) game.lookup("#augurysmall");
			augurybig = (ImageView) game.lookup("#augurybig");
			BloodWarrior = (ImageView) game.lookup("#BloodWarrior");
			ArcingSlice = (ImageView) game.lookup("#ArcingSlice");
			Zhatian = (ImageView) game.lookup("#Zhatian");
			undeadarmysmall = (ImageView) game.lookup("#undeadarmysmall");
			undeadarmybig = (ImageView) game.lookup("#undeadarmybig");
			//undeadarmybig2 = (ImageView) game.lookup("#undeadarmybig2");
			hibernating = (ImageView) game.lookup("#hibernating");
			dragonflame = (ImageView) game.lookup("#dragonflame");
			
			backgroundpic = (ImageView) game.lookup("#background");
			warriorheropowersmall = (ImageView) game.lookup("#warriorheropowersmall");
			warriorheropowerbig = (ImageView) game.lookup("#warriorheropowerbig");
			shield1 = (ImageView) game.lookup("#shield1");
			
			manapic = (ImageView) game.lookup("#mana");
			manapic2 = (ImageView) game.lookup("#mana2");
			shieldblock = (ImageView) game.lookup("#shieldblock");
			
			
			start.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					button.play();
					button.stop();
					if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
						button.play();
					}
					stage.setScene(chooseprofession);
					
					//backgroundpic.setVisible(false);
					warpic.setVisible(false);
					guapic.setVisible(false);
					thipic.setVisible(false);
					engpic.setVisible(false);
					ranpic.setVisible(false);
					elepic.setVisible(false);
					necpic.setVisible(false);
					mespic.setVisible(false);
					augury.setVisible(false);
					augurysmall.setVisible(false);
					augurybig.setVisible(false);
					warriorheropowersmall.setVisible(false);
					warriorheropowerbig.setVisible(false);
					shield1.setVisible(false);
					
					armornumber1.setVisible(false);
					//BloodWarrior.setVisible(false);
					ArcingSlice.setVisible(false);
					shieldblock.setVisible(false);
					Zhatian.setVisible(true);
					undeadarmysmall.setVisible(true);
					undeadarmybig.setVisible(false);
					hibernating.setVisible(true);
					dragonflame.setVisible(true);
					//undeadarmybig2.setVisible(false);
					playerwon.setVisible(false);
					zhatianwon.setVisible(false);
					attack.setVisible(false);
					endu.setVisible(false);
					
				};
			});
			exit.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					button.onRepeatProperty();
					button.play();
					button.stop();
					if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
						button.play();
					}
					Platform.exit();
				};
			});
			intro.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					button.onRepeatProperty();
					button.play();
					button.stop();
					if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
						button.play();
					}
					stage.setScene(intromode);
				};
			});
			backtomenu.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					button.onRepeatProperty();
					button.play();
					button.stop();
					if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
						button.play();
					}
					stage.setScene(menu);
				};
			});
			gotoprofessionintro.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					button.play();
					button.stop();
					if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
						button.play();
					}
					stage.setScene(professionintro);
				};
			});
			backtointro.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					button.play();
					button.stop();
					if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
						button.play();
					}
					stage.setScene(intromode);
				};
			});
			
			//endturn.setOnMouseClicked(new EventHandler<Event>() {
				//public void handle(Event event) {
					
				//};
			//});
			
				gameLoop = new Timeline(new KeyFrame(Duration.millis(1000 / FPS), new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if(timer % FPS == 0) {
							thinktime --;
							Time.setText("Time:"+thinktime);
							if(thinktime == 0 && turn == 0) {
								gameLoop.stop();
								Player.setText("Zhatian's turn");
								timer = 0;
								thinktime = 30;
								Time.setText("Time:"+thinktime);
								gameLoop.play();
								turn = 1;
								k2 = 0;
								if(mananumber < 10) {
									mananumber = 0;
									manaturn ++;
									mananumber += manaturn;
									mana2.setText(""+mananumber2);
								}
								else {
									mananumber2 = 10;
									mana2.setText(""+mananumber2);
								}
							}
							else if(thinktime == 0 && turn == 1) {
								turn = 0;
								gameLoop.stop();
								Player.setText("Player's turn");
								timer = 0;
								thinktime = 30;
								Time.setText("Time:"+thinktime);
								gameLoop.play();
								k1 = 0;
								if(mananumber < 10) {
									mananumber2 = 0;
									mananumber2 += manaturn;
									mana.setText(""+mananumber);
								}
								else {
									mananumber = 10;
									mana.setText(""+mananumber);
								}
							}
						}
						timer ++;
					}
				}));
				gameLoop.setCycleCount(-1);
				war.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						button.play();
						button.stop();
						if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
							button.play();
						}
						stage.setScene(game);
							player1.setVisible(false);
							
							gw2.stop();
							wow.play();
							warpic.setVisible(true);
							warriorheropowersmall.setVisible(true);
							shieldblock.setVisible(true);
							//BloodWarrior.setVisible(true);
							ArcingSlice.setVisible(true);
							augury.setVisible(true);
							gameLoop.play();
					}

				});	
				
				
				warriorheropowersmall.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(k1 == 0 && mananumber >= 2) {
							armor1 ++;
							armornumber1.setText(""+armor1);
							shield1.setVisible(true);
							armornumber1.setVisible(true);
							HP2 --;
							Player2HP.setText(""+HP2);
							k1 = 1;
							mananumber -= 2;
							mana.setText(""+mananumber);
							if(HP2 <= 0) {
								playerwon.setVisible(true);
							}
						}
					};
				});
				undeadarmysmall.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(k2 == 0 && mananumber2 >= 2) {
							if(armor1 > 0) {
								if(armor1 < 2) {
									armor1 -= 1;
									HP1 -= 1;
									Player1HP.setText(""+HP1);
									armornumber1.setVisible(false);
									shield1.setVisible(false);
								}
								else if(armor1 >= 2) {
									armor1 -= 2;
									if(armor1 > 2)
										armornumber1.setText(""+armor1);
									else {
										armornumber1.setVisible(false);
										shield1.setVisible(false);
									}
								}
							}
							else {
								HP1 -= 2;
								Player1HP.setText(""+HP1);
							}
							k2 = 1;
							mananumber2 -= 2;
							mana2.setText(""+mananumber2);
							if(HP1 <= 0) {
								zhatianwon.setVisible(true);
							}
						}
					};
				});	
						
				undeadarmysmall.setOnMouseEntered(new EventHandler<Event>() {
					public void handle(Event event) {
						undeadarmybig.setVisible(true);
					};
				});
				undeadarmysmall.setOnMouseExited(new EventHandler<Event>() {
					public void handle(Event event) {
						undeadarmybig.setVisible(false);
					};
					
				});	
				warriorheropowersmall.setOnMouseEntered(new EventHandler<Event>() {
					public void handle(Event event) {
						warriorheropowerbig.setVisible(true);
					};
					
				});	
				warriorheropowersmall.setOnMouseExited(new EventHandler<Event>() {
					public void handle(Event event) {
						warriorheropowerbig.setVisible(false);
					};
					
				});
						
				shieldblock.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(mananumber >= 3) {
							armor1 += 8;
							mananumber -= 3;
							armornumber1.setText(""+armor1);
							mana.setText(""+mananumber);
							shield1.setVisible(true);
							armornumber1.setVisible(true);
				
						}
						
					};
				});
				ArcingSlice.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(mananumber >= 4) {
							HP2 -= 6;
							mananumber -= 4;
							Player2HP.setText(""+HP2);
							mana.setText(""+mananumber);
							sword.play();
							sword.stop();
							if(button.getStatus()!=MediaPlayer.Status.STOPPED) {
								sword.play();
							}
						}
						if(HP2 <= 0) {
							playerwon.setVisible(true);
						}
						
					};
				});
				augury.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(mananumber >= 8) {
							augury.setVisible(false);
							augurysmall.setVisible(true);
							mananumber -= 8;
							mana.setText(""+mananumber);
							attack.setVisible(true);
							endu.setVisible(true);
						}
					};
				});
				augurysmall.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(weapon == 0) {
							if(HP1 < 15) {
								attacknumber += 2;
								attack.setText(""+attacknumber);
								HP2 -= 7;
								Player2HP.setText(""+HP2);
								endure --;
								endurenumber --;
								endu.setText(""+endurenumber);
							}
							else {
								HP2 -= 5;
								Player2HP.setText(""+HP2);
								endure --;
								endurenumber --;
								endu.setText(""+endurenumber);
							}
						}
						if(endure == 0) {
							augurysmall.setVisible(false);
							augury.setVisible(true);
							attack.setVisible(false);
							endu.setVisible(false);
							endure = 3;
							endurenumber = 3;
							endu.setText(""+endurenumber);
						}
						if(HP2 <= 0) {
							playerwon.setVisible(true);
						}
						weapon = 1;
					};
				});
				augury.setOnMouseEntered(new EventHandler<Event>() {
					public void handle(Event event) {
						augurybig.setVisible(true);
					};
				});
				augury.setOnMouseExited(new EventHandler<Event>() {
					public void handle(Event event) {
						augurybig.setVisible(false);
					};
					
				});	
				//BloodWarrior.setOnMouseClicked(new EventHandler<Event>() {
					//public void handle(Event event) {
						//if(mananumber >= 3) {
							
						//}
					//};
				//});
				hibernating.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(mananumber2 >= 2) {
							if(HP2 > 24) {
								HP2 = 30;
							}
							else {
								HP2 += 6;
							}
							mananumber2 -= 2;
							Player2HP.setText(""+HP2);
							mana2.setText(""+mananumber2);
						}
						
					};
				});
				dragonflame.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(mananumber2 >= 3) {
							if(armor1 > 0) {
								if(armor1 < 5) {
									HP1 -= (5-armor1);
									armor1 = 0;
									Player1HP.setText(""+HP1);
									armornumber1.setVisible(false);
									shield1.setVisible(false);
								}
								else if(armor1 >= 5) {
									armor1 -= 5;
									if(armor1 > 0)
										armornumber1.setText(""+armor1);
									else {
										armornumber1.setVisible(false);
										shield1.setVisible(false);
									}
								}
							}
							else {
								HP1 -= 5;
								Player1HP.setText(""+HP1);
							}
							mananumber2 -= 3;
							mana2.setText(""+mananumber2);
						}
						if(HP1 <= 0) {
							zhatianwon.setVisible(true);
						}
					};
				});
				gua.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						
							player1.setVisible(false);
							
							
							guapic.setVisible(true);
					
							stage.setScene(game);
							
							
							gw2.stop();
							wow.play();
						
					};
				});
				thi.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						
							player1.setVisible(false);
							
							thipic.setVisible(true);
						
							stage.setScene(game);
							
							
							gw2.stop();
							wow.play();
						};
					
				});
				eng.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						
							player1.setVisible(false);
							
							engpic.setVisible(true);
					
							stage.setScene(game);
							
							
							gw2.stop();
							wow.play();
						
					};
				});
				ran.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						
							player1.setVisible(false);
							
							ranpic.setVisible(true);
						
							stage.setScene(game);
							
							
							gw2.stop();
							wow.play();
						
					};
				});
				ele.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						
							player1.setVisible(false);
							
							elepic.setVisible(true);
						
						
							stage.setScene(game);
							
							
							gw2.stop();
							wow.play();
						
					};
				});
				nec.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						
							player1.setVisible(false);
							
							necpic.setVisible(true);
						
						
							stage.setScene(game);
							
							
							gw2.stop();
							wow.play();
						
					};
				});
				mes.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						
							player1.setVisible(false);
							
							mespic.setVisible(true);
							
						
							
							stage.setScene(game);
							
							
							gw2.stop();
							wow.play();
						
					};
				});
				
				endturn.setOnMouseClicked(new EventHandler<Event>() {
					public void handle(Event event) {
						if(turn == 0) {
							gameLoop.stop();
							Player.setText("Zhatian's turn");
							timer = 0;
							thinktime = 30;
							Time.setText("Time:"+thinktime);
							gameLoop.play();
							turn = 1;
							k2 = 0;
							if(mananumber < 10) {
								mananumber = 0;
								manaturn ++;
								mananumber += manaturn;
								mana2.setText(""+mananumber2);
							}
							else {
								mananumber2 = 10;
								mana2.setText(""+mananumber2);
							}
							weapon = 0;
						}
						else if(turn == 1) {
							turn = 0;
							gameLoop.stop();
							Player.setText("Player's turn");
							timer = 0;
							thinktime = 30;
							Time.setText("Time:"+thinktime);
							gameLoop.play();
							k1 = 0;
							if(mananumber < 10) {
								mananumber2 = 0;
								mananumber2 += manaturn;
								mana.setText(""+mananumber);
							}
							else {
								mananumber = 10;
								mana.setText(""+mananumber);
							}
						}
						k1 = 0;
					};
				});		
				
				//root.getChildren().add(warpic);
				
				
		    	//BorderPane root = new BorderPane();
				//Scene scene = new Scene(root,400,400);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(menu);
				primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
