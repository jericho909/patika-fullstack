const Person = (props) => {
    return(
        <div className="person">
            <img className="person-avatar" src={props.avatar} alt="" />
            <h1 className="person-name">{props.name}</h1>
            <div className="person-right">
                <div className="person-list-entry">
                    <h2 className="list-type">Phone Numbers</h2>
                    <ul>
                        {props.phoneNumbers.map((item)=>{
                            return <li key={item.name}>
                                <span className="list-label">{item.name}</span> 
                                <span className="list-value">{item.number}</span>
                            </li>
                        })}
                    </ul>
                </div>
                <div className="person-list-entry">
                    <h2 className="list-type">Address</h2>
                    <ul>
                        {props.addresses.map((item)=>{
                            return <li key={item.name}>
                                <span className="list-label">{item.name}</span> 
                                <span className="list-value">{item.address}</span>
                            </li>
                        })}
                    </ul>
                </div>
                <div className="person-list-entry">
                    <h2 className="list-type">Emails</h2>
                    <ul>
                        {props.emails.map((item)=>{
                            return <li key={item.name}>
                                <span className="list-label">{item.name}</span> 
                                <span className="list-value">{item.email}</span>
                            </li>
                        })}
                    </ul>
                </div>
            </div>
            
            
        </div>
        
    )
}

export default Person;
