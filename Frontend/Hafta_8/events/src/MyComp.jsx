import {useState} from "react";

function MyComp() {
    const [name, setName] = useState("Guest");
    const [quantity, setQuantity] = useState(1);
    const [comment, setComment] = useState("");
    const [payment, setPayment] = useState("");
    const [shipping, setShipping] = useState("");

    function handleNameChange(event) {
        setName(event.target.value);
    }

    function handleQuantityChange(event) {
        setQuantity(event.target.value);
    }

    function handleCommentChange(event) {
        setComment(event.target.value);
    }

    function handlePPaymentChange() {
        setPayment(event.target.value);
    }

    function handleShippingChange() {
        setShipping(event.target.value);
    }

    return (
        <div>
            <input type="text" value={name} onChange={handleNameChange}/>
            <p>Name: {name}</p>

            <input type="number" value={quantity} onChange={handleQuantityChange}/>
            <p>Quantity: {quantity}</p>

            <textarea name="" id="" cols="30" rows="10" value={comment} onChange={handleCommentChange} placeholder="Please give detailed instructions."></textarea>
            <p>Comment: {comment}</p>

            <select name="" id="" value={payment} onChange={handlePPaymentChange}>
                <option value="">Select an option</option>
                <option value="Visa">Visa</option>
                <option value="Mastercard">Mastercard</option>
                <option value="American Express">American Express</option>
            </select>
            <p>Your choice of payment is: {payment}</p>

            <label htmlFor="">
                <input type="radio" value="Pick Up" checked={shipping === "Pick Up"} onChange={handleShippingChange} />
                Pick Up
            </label>
            <label htmlFor="">
            <input type="radio" value="Delivery" checked={shipping === "Delivery"} onChange={handleShippingChange} />
                Delivery
            </label>
            <p>You choice of delivery: {shipping}</p>
        </div>
    );
}

export default MyComp;