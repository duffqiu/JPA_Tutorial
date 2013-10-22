/**
 * 
 */
package com.bhbz.jpatest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * @author egecqiu
 * 
 */
@Entity
@DiscriminatorValue(value = "2")
public class PollTopic extends Topic {
    @Column(name = "MULTIPLE")
    private int multiple;

    @Column(name = "MAX_CHOICE")
    private int maxChoices;

    @OneToMany(mappedBy = "pollTopic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PollOptions> options = new HashSet<>();

    @Transient
    private int type = 2;

    protected PollTopic() {

    }

    public PollTopic(String title, Date time, int views, int multiple,
	    int maxChoices) {
	super(title, time, views);
	this.multiple = multiple;
	this.maxChoices = maxChoices;
    }

    public Set<PollOptions> getOptions() {
	return options;
    }

    public void setOptions(Set<PollOptions> options) {
	this.options = options;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "PollTopic: " + super.toString() + "[multiple=" + multiple
		+ ", maxChoices=" + maxChoices + ", options=" + options
		+ ", type=" + type + "]";
    }

}
