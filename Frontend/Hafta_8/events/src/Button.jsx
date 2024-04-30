function Button(){
    

    const handleClick = (e) => {
            e.target.textContent = "OUCH!";
    }
    return(
        <button onDoubleClick={handleClick}>Click Me</button>
    );
}

export default Button;