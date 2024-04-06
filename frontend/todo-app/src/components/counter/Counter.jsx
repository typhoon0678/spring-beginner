import './Counter.css'
import {useState} from "react";
import CounterButton from "./CounterButton";

export default function Counter() {

    const [count, setCount] = useState(0);

    function increment(by) {
        setCount(count + by);
    }

    function decrement(by) {
        setCount(count - by);
    }

    function reset() {
        setCount(0);
    }

    return (
        <>
            <span className="totalCount">{count}</span>
            <CounterButton increment={increment} decrement={decrement} reset={reset}/>
            <CounterButton by={2} increment={increment} decrement={decrement} reset={reset}/>
            <CounterButton by={3} increment={increment} decrement={decrement} reset={reset}/>
            <button className="resetButton" onClick={reset}>Reset</button>
        </>
    )
}

