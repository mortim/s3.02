package com.cosmopolis;

public enum Raccourcis {
    
    PAVE_1(49),
    PAVE_2(50),
    PAVE_3(51),
    PAVE_4(52),
    PAVE_5(53),
    PAVE_6(54),
    PAVE_7(55),
    PAVE_8(56),
    PAVE_9(57),
    
    SPECIAUX_1(38),
    SPECIAUX_2(233),
    SPECIAUX_3(34),
    SPECIAUX_4(39),
    SPECIAUX_5(40),
    SPECIAUX_6(45),
    
    Q(113),
    F(102);


    private int id_touche;

    private Raccourcis(int id_touche) {
        this.id_touche = id_touche;
    }

    public int getID() {
        return this.id_touche;
      }
    
    
}