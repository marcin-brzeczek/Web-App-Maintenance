package entity;

import entity.Awaria;
import entity.Operator;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-26T23:11:21")
@StaticMetamodel(Maszyna.class)
public class Maszyna_ { 

    public static volatile SetAttribute<Maszyna, Awaria> awariaSet;
    public static volatile SingularAttribute<Maszyna, String> dostepnosc;
    public static volatile SingularAttribute<Maszyna, String> nazwaLinii;
    public static volatile SingularAttribute<Maszyna, String> nazwaMaszyny;
    public static volatile SingularAttribute<Maszyna, Integer> id;
    public static volatile SetAttribute<Maszyna, Operator> operatorSet;

}