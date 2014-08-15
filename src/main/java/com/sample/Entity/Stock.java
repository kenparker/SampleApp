package com.sample.Entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


/*
 *
 * @author magang
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Stock.FIND_ALL, query = "select p from Stock p order by p.symbol"),
    @NamedQuery(name = Stock.FIND_BY_SYMBOL, query = "select p from Stock p where p.symbol=:sy")
})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String FIND_ALL = "Stock.findAll";
    public static final String FIND_BY_SYMBOL = "Stock.findBySymbol";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String symbol;
    private String name;
    
    
    public Stock()
    {
    }

    public Stock(String symbol, String name)
    {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
       
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    
    
    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.symbol);
        hash = 47 * hash + Objects.hashCode(this.name);
        return hash;
    }
    

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Stock other = (Stock) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol))
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString()
    {
        return " Symbol[ id=" + id + " ] "
                + " Symbol : " + this.symbol
                + " Name : " + this.name;
    }
    
    

}
