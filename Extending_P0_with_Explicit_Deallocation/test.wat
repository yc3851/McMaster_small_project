(module
(import "P0lib" "write" (func $write (param i32)))
(import "P0lib" "writeln" (func $writeln))
(import "P0lib" "read" (func $read (result i32)))
(import "P0lib" "new" (func $new (param i32)))
(import "P0lib" "dispose" (func $dispose (param i32)))
(import "P0lib" "set_value" (func $set_value (param i32) (param i32)))
(import "P0lib" "get_value" (func $get_value (param i32) (result i32)))
(import "P0lib" "set_value1" (func $set_value1 (param i32) (param i32) (param i32)))
(import "P0lib" "get_value1" (func $get_value1 (param i32) (param i32) (result i32)))
(import "P0lib" "set_value2" (func $set_value2 (param i32) (param i32)))
(func $program
i32.const 1
call $new
i32.const 4
call $new
i32.const 3
i32.const 0
i32.const 1
call $set_value1
i32.const 4
i32.const 0
i32.const 4
call $set_value1
i32.const 0
i32.const 4
call $get_value1
call $write
i32.const 0
i32.const 1
call $get_value1
call $write
i32.const 4
call $dispose
)
(memory 1)
(start $program)
)
